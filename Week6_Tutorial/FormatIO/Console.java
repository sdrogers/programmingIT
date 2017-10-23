/*
 *	Console.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 16:23:47 $
 *	$Revision: 1.10 $
 */

package	FormatIO;

import	java.io.*;
import	java.awt.*;
import	java.awt.event.*;
import	java.util.*;

	/***************/
	/*             */
	/*  ConsoleIn  */
	/*             */
	/***************/

/*======================*/
	class	ConsoleIn	extends	FormatIn
/*======================*/
	{
	private	Console	con;

	ConsoleIn(Console c)	{ con = c; }
protected	int	get_char()	{ return con.get_char(); }
	}

	/******************/
	/*                */
	/*  ConsoleEntry  */
	/*                */
	/******************/

/*=================*/
class	ConsoleEntry
/*=================*/
	{
	public	int	c;	// the character
	public	int	t;	// the type

public	ConsoleEntry(int i, int type)	{ c = i; t = type; }
	}

	/*******************/
	/*                 */
	/*  ConsoleCanvas  */
	/*                 */
	/*******************/

/*=================================*/
class	ConsoleCanvas extends Canvas
/*=================================*/
	{
/*
 *  Data
 */

	private	Console	con;
	private	int	width, height;

/*
 *  Basic maintenance methods
 */

/*-------------------------------------------*/
public	ConsoleCanvas(Console c, int w, int h)
/*-------------------------------------------*/
	{
	con = c;
	width = w;
	height = h;
	}

/*------------------------*/
public	void	addNotify()
/*------------------------*/
	{
	super.addNotify();
	setSize(width, height);
	}

/*---------------------------------*/
public	boolean	isFocusTraversable()
/*---------------------------------*/
	{
	return true;
	}

/*------------------------------*/
public	void	paint(Graphics g)
/*------------------------------*/
	{
	con.draw_all();
	}

	}

	/*************/
	/*           */
	/*  Console  */
	/*           */
	/*************/

/*====================*/
public	class	Console
/*====================*/
		extends		FormatOutput
		implements	FormatInput
				,KeyListener,    ActionListener
				,MouseListener,  AdjustmentListener
				,WindowListener, ComponentListener
	{
/*
 *  Constants
 */

	private	final	static	String	NAME = "Console Window";
	private	final	static	int	NROWS = 30, NCOLS = 80;

		// character types
	final	static	int	T_USER   = 0;
	final	static	int	T_PROG   = 1;
	final	static	int	T_ERROR  = 2;
	final	static	int	T_PROMPT = 3;
/*
 *  Data
 */

	private	ConsoleIn	cin;
	private	ConsoleStore	store;
	private	Frame	frame;
	private	ConsoleCanvas	canvas;
	private	Scrollbar	sbar;

	private	int	nrows, ncols;
	private	int	char_width, char_height;
	private	int	width, height;

		// support for get (reading from program)
	private	int	read_next = 0;	// index of next read char
	private	int	read_last = -1;	// index of last char available to read
	private	boolean	is_blocked = false;
	private	Thread	our_thread;

		// infinite loop detection
	private	int	count_since_input = 0;
	private	int	MAX_SINCE_INPUT = 4000;

	/******************/
	/*  Constructors  */
	/******************/

public	Console()		{ this(NAME, NROWS, NCOLS); }
public	Console(String name)	{ this(name, NROWS, NCOLS); }
public	Console(int nr, int nc)	{ this(NAME, nr, nc); }

/*-----------------------------------------*/
public	Console(String name, int nr, int nc)
/*-----------------------------------------*/
	{
	cin = new ConsoleIn(this);

	nrows = nr;
	ncols = nc;

		// create the Frame
	frame = new Frame(name);
	frame.addWindowListener(this);

		// create font and find char_width and char_height
	Font	font = new Font("Monospaced", Font.PLAIN, 12);
	frame.setFont(font);
	FontMetrics	fm = frame.getFontMetrics(font);
	char_width  = fm.charWidth('w');
	char_height = fm.getHeight();

		// calculate the canvas width and height
	width  = (ncols + 2) * char_width;
	height = (nrows + 2) * char_height;

		// Create the Canvas
	canvas = new ConsoleCanvas(this, width, height);
	canvas.addKeyListener(this);
	canvas.addMouseListener(this);
	canvas.addComponentListener(this);
	frame.add("Center", canvas);

		// Create the Scrollbar
		// orientation, value, thumb_size, min, max
	sbar = new Scrollbar(Scrollbar.VERTICAL, 0, nrows, 0, nrows);
	sbar.addAdjustmentListener(this);
	frame.add("East", sbar);

		// Put in a couple of buttons
	Panel	panel = new Panel();
	panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
 
	Button	b_save = new Button("Save As");
	b_save.addActionListener(this);
	panel.add(b_save);
 
	Button	b_clear = new Button(" Clear ");
	b_clear.addActionListener(this);
	panel.add(b_clear);
 
	Button	b_close = new Button(" Close ");
	b_close.addActionListener(this);
	panel.add(b_close);

	Button	b_quit = new Button(" Quit  ");
	b_quit.addActionListener(this);
	panel.add(b_quit);

	frame.add("North", panel);
	store = new ConsoleStore(canvas, sbar, char_width, char_height);

		// Finish off
	frame.pack();
	frame.setVisible(true);
	}

	/******************************/
	/*  Pass on the canvas paint  */
	/******************************/

/*---------------*/
void	draw_all()
/*---------------*/
	{
	store.redraw_all();
	}

	/**********************/
	/*  Manipulate State  */
	/**********************/

/*------------------------------------*/
public	void	turn_off_infity_check()
/*------------------------------------*/
	{
	MAX_SINCE_INPUT = 0;
	}

	/****************************/
	/*  Parent class overrides  */
	/****************************/

/*-------------------------------------*/
protected	void	put_char(char c)
/*-------------------------------------*/
	{
	store.add_char((int) c, T_PROG);

		// check if too much output without input (infinite loop?)
	count_since_input++;
	if (MAX_SINCE_INPUT == 0)	// test turned off
		return;
	if (count_since_input > MAX_SINCE_INPUT)
		{
		store.add_string("\n" + MAX_SINCE_INPUT
		+ " characters since input"
		+ "\nIf you are in an infinite loop, hit the Quit button"
		+ "\nOtherwise hit return to continue with the output\n",
		T_ERROR);
		count_since_input = 0;
		skipLine();
		}
	}

/*-------------------------*/
public	double	readDouble()
/*-------------------------*/
	{
	{ return cin.readDouble(); }
//	catch (EofX x)	{}
//	catch (NFX x)	{ store.add_string(x.toString(), T_ERROR); }
//	return 1.0;
	}

/*----------------------*/
public	int	readInt()
/*----------------------*/
	{
	{ return cin.readInt(); }
//	catch (EofX x)	{}
//	catch (NFX x)	{ store.add_string(x.toString(), T_ERROR); }
//	return 1;
	}

/*--------------------------*/
public	boolean	readBoolean()
/*--------------------------*/
	{
	{ return cin.readBoolean(); }
//	catch (EofX x)	{}
//	catch (NFX x)	{ store.add_string(x.toString(), T_ERROR); }
//	return true;
	}

public	String	setWhite(String s)
	{ return cin.setWhite(s); }
public	char	readChar()
	{  { return cin.readChar(); } }
public	String	readLine()
	{ { return cin.readLine(); }  }
public	String	readWord()
	{  { return cin.readWord(); }  }

public	char	getChar()
	{ { return cin.getChar(); }  }
public	String	getLine()
	{  { return cin.getLine(); }  }

public	void	skipLine()
	{  { cin.skipLine(); }  }
public	boolean	eof()
	{ return cin.eof(); }

/*-------------------------------*/
protected	int	get_char()
/*-------------------------------*/
	{
	for (;;)
		{
/*
 *  If no input character is available then we suspend this thread.
 *  We rely on keystrokes being delivered by another thread.
 *  The key listener method will unblock this thread when a newline
 *  is typed by the user (line buffering).
 *  We add a prompt character to indicate that the program is
 *  waiting for user input.
 */
		if (read_next > read_last)	// no input available
			{
			store.set_prompt(true);
			is_blocked = true;
			our_thread = Thread.currentThread();
			our_thread.suspend();
			}

		ConsoleEntry ce = store.get_char_at(read_next++);
		if (ce.t == T_USER)	// user typed this
			return ce.c;
		}
	}

	/***************************/
	/*  Clear, Save As, Close  */
	/***************************/

/*-------------------------*/
private	void	write_file()
/*-------------------------*/
	{
	FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
	dialog.resize(480, 240);
	dialog.show();
	String	file_name = dialog.getDirectory() + dialog.getFile();
	if (file_name != null)
		write_file(file_name);
	}

/*-----------------------------------------*/
private	void	write_file(String file_name)
/*-----------------------------------------*/
	{
	FileOutputStream	dest;
	try
		{
		dest = new FileOutputStream(file_name);
		store.write_file(dest);
		dest.close();
		}

	catch(IOException x)
		{
		store.add_string("\nCan't open file " + file_name + "\n",
			T_ERROR);
		}
	}

/*--------------------*/
private	void	close()
/*--------------------*/
	{
	frame.hide();
	}

	/*************************/
	/*  KeyListener methods  */
	/*************************/

/*---------------------------------*/
public	void	keyTyped(KeyEvent e)
/*---------------------------------*/
	{
	count_since_input = 0;
/*
 *  getKeyCode is undefined for typed events, although it is the
 *  correct ascii code for pressed and release events.
 */
	int	key = (int)e.getKeyChar();
/*
 *  Line editing can only erase text typed in by the user,
 *  providing it is not a newline.
 */
	if (key == '\b')	// backspace (last character)
		{
		store.sub_last_char();
		return;
		}

	if (key == 127)		// delete (last user typed line)
		{
		while (store.sub_last_char())
			;
		return;
		}

		// normal character
	int	i = store.add_char(key, T_USER);
/*
 *  Check to see if the reading thread needs to be resumed.
 *  If so, then also erase the pending input prompt.
 */
	if (is_blocked && key == '\n')
		{
		read_last = i;
		store.set_prompt(false);
		is_blocked = false;
		our_thread.resume();
		}
	}

public	void	keyPressed(KeyEvent e)	{ }
public	void	keyReleased(KeyEvent e)	{ }

	/***************************/
	/*  MouseListener methods  */
	/***************************/

/*---------------------------------------*/
public	void	mouseEntered(MouseEvent e)
/*---------------------------------------*/
	{
	canvas.requestFocus();	// keyboard events go to the canvas
	}

public	void	mouseClicked(MouseEvent e)	{ }
public	void	mouseExited(MouseEvent e)	{ }
public	void	mousePressed(MouseEvent e)	{ }
public	void	mouseReleased(MouseEvent e)	{ }

	/****************************/
	/*  ActionListener methods  */
	/****************************/

/*-------------------------------------------*/
public	void	actionPerformed(ActionEvent e)
/*-------------------------------------------*/
	{
	if (e.getActionCommand().equals("Save As"))
		write_file();

	if (e.getActionCommand().equals(" Clear "))
		store.clear();

	if (e.getActionCommand().equals(" Close "))
		close();

	if (e.getActionCommand().equals(" Quit  "))
		System.exit(0);
	}

	/********************************/
	/*  AdjustmentListener methods  */
	/********************************/

/*------------------------------------------------------*/
public	void	adjustmentValueChanged(AdjustmentEvent e)
/*------------------------------------------------------*/
	{
	store.redraw_all(e.getValue());
	}

	/****************************/
	/*  WindowListener methods  */
	/****************************/

/*-----------------------------------------*/
public	void	windowClosing(WindowEvent e)
/*-----------------------------------------*/
	{
	System.exit(0);
	}

public	void	windowActivated(WindowEvent e)	{ }
public	void	windowClosed(WindowEvent e)	{ }
public	void	windowDeactivated(WindowEvent e)	{ }
public	void	windowDeiconified(WindowEvent e)	{ }
public	void	windowIconified(WindowEvent e)	{ }
public	void	windowOpened(WindowEvent e)	{ }

	/*******************************/
	/*  ComponentListener methods  */
	/*******************************/

/*-----------------------------------------------*/
public	void	componentResized(ComponentEvent e)
/*-----------------------------------------------*/
	{
	Dimension	d = canvas.getSize();
	width  = d.width;
	height = d.height;

		// adjust row x col parameters
	ncols = width  / char_width  - 2;
	nrows = height / char_height - 2;

	if (store != null)	// store not created when does this first
		store.repaginate(nrows, ncols);
	}

public	void	componentHidden(ComponentEvent e)	{ }
public	void	componentMoved(ComponentEvent e)	{ }
public	void	componentShown(ComponentEvent e)	{ }

	}
