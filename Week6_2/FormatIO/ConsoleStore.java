/*
 *	ConsoleStore.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 10:51:30 $
 *	$Revision: 1.1 $
 *
 *	Java awt uses god knows how many threads.  The Java synchronization
 *	mechanism is woefully inadequate.  We just have to make sure we
 *	define atomic operations for anything that might involve more than
 *	one thread.  All drawing routines go via this class.
 */

package	FormatIO;

import	java.io.*;
import	java.awt.*;
import	java.util.*;

/*=================*/
class	ConsoleStore
/*=================*/
	{
	private	Canvas	canvas;
	private	Scrollbar	sbar;

	private	int	char_width, char_height;

	private	Color[]	type_colour =
		{
		Color.blue,
		Color.black,
		Color.red,
		new Color(0.0F, 0.5F, 0.0F)
		};
	private	int	prompt_char = '*';
	private	boolean	prompt = false;

		// entries keep (char, type) pairs for each char
	private	Vector	entries = new Vector(100, 100);
	private	int	first_element = 0;	// non-zero after clear

		// current state
	private	int	nrows, ncols;
	private	int	row = 0, col = 0;	// position of next char
	private	int	row0 = 0;		// first row on screen
	private	int	last_row;		// as seen by scrollbar

		// permanant workspace for optimizations
	private	char[]	by = new char[1];

/*------------------------------------------------*/
ConsoleStore(Canvas c, Scrollbar s, int cw, int ch)
/*------------------------------------------------*/
	{
	canvas = c;
	sbar = s;
	char_width  = cw;
	char_height = ch;
	}

	/***********************/
	/*  Atomic Operations  */
	/***********************/

/*------------------------------------------*/
synchronized	void	set_prompt(boolean p)
/*------------------------------------------*/
	{
	if (prompt == p)
		return;	// no change
	if (prompt)
		undraw_char(prompt_char);
	prompt = p;
	if (prompt)
		draw_char(prompt_char, Console.T_PROMPT);
	}

/*---------------------------------------------------*/
synchronized	ConsoleEntry	get_char_at(int index)
/*---------------------------------------------------*/
	{
	return (ConsoleEntry) entries.elementAt(index);
	}

/*---------------------------------------------------*/
synchronized	void	add_string(String s, int type)
/*---------------------------------------------------*/
	{
	check_scrolling();
	if (prompt)
		undraw_char(prompt_char);
	for (int i = 0; i < s.length(); i++)
		{
		int	c = (int) s.charAt(i);
		entries.addElement(new ConsoleEntry(c, type));
		draw_char(c, type);
		}
	if (prompt)
		draw_char(prompt_char, Console.T_PROMPT);
	}

/*----------------------------------------------*/
synchronized	int	add_char(int c, int type)
/*----------------------------------------------*/
	{
	check_scrolling();
	entries.addElement(new ConsoleEntry(c, type));
	if (prompt)
		undraw_char(prompt_char);
	draw_char(c, type);
	if (prompt)
		draw_char(prompt_char, Console.T_PROMPT);

	return entries.size() - 1;
	}

/*
 *  Can only remove the last char if its type is T_USER or T_PROMPT
 *  and the character is not a newline.  Returns true if successful.
 */

/*------------------------------------*/
synchronized	boolean	sub_last_char()
/*------------------------------------*/
	{
	int	i = entries.size() - 1;	// avoid concurrent updates to entries
	ConsoleEntry ce = (ConsoleEntry) entries.elementAt(i);
	if (ce.c == '\n' || ce.t == Console.T_PROG || ce.t == Console.T_ERROR)
		return false;

	entries.removeElementAt(i);
	if (prompt)
		undraw_char(prompt_char);
	undraw_char(ce.c);
	if (prompt)
		draw_char(prompt_char, Console.T_PROMPT);

	return true;
	}

/*---------------------------------*/
synchronized	void	redraw_all()	// called by paint, don't clear
/*---------------------------------*/
	{
	draw_all(false);
	}

/*---------------------------------------*/
synchronized	void	redraw_all(int r0)	// called by us, clear
/*---------------------------------------*/
	{
	row0 = r0;
	draw_all(true);
	}

/*-----------------------------------------------*/
synchronized	void	repaginate(int nr, int nc)
/*-----------------------------------------------*/
	{
	nrows = nr;
/*
 *  If column width changes then we have to repaginate, which will change
 *  row, col, row0.  Try and keep the top line the same, which means
 *  recalculating row0.  First find index of first character on line row0.
 *  Then find new line with that character, which is new row0.
 */
	if (ncols != nc)
		{
			// repeat pagination with old values
		int	index0 = 0;
		row = 0;
		col = 0;
		int	len = entries.size();
		for (int i = first_element; i < len; i++)
			{
			if (row == row0)
				{
				index0 = i;
				break;
				}

			ConsoleEntry ce = (ConsoleEntry) entries.elementAt(i);

			if (ce.c == '\n' || col >= ncols)
				{
				row++;
				col = 0;
				}
			else
				col++;
			}

			// now paginate with new values
		ncols = nc;
		row = 0;
		col = 0;
		for (int i = first_element; i < len; i++)
			{
			if (index0 == i)
				{
				row0 = row;
				index0 = i - 1;	// test never true again
				}

			ConsoleEntry ce = (ConsoleEntry) entries.elementAt(i);

			if (ce.c == '\n' || col >= ncols)
				{
				row++;
				col = 0;
				}
			else
				col++;
			}
		}
/*
 *  We may have many more rows visible, and last_row should
 *  reflect that.  last_row = max(row0 + nrows, row)
 *  last_row can get larger or smaller, but cannot be less than row.
 */
	last_row = max(row0 + nrows, row);

	sbar.setValues(row0, nrows, 0, last_row);
	sbar.setBlockIncrement(nrows);
	sbar.setVisibleAmount(nrows);

		// paint is called automatically
	}

/*------------------------------*/
private	int	max(int a, int b)
/*------------------------------*/
	{
	if (a > b)
		return a;
	else
		return b;
	}

/*----------------------------*/
synchronized	void	clear()
/*----------------------------*/
	{
	entries.addElement(new ConsoleEntry('\n', Console.T_PROG));
	entries.addElement(new ConsoleEntry('\n', Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('C',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('L',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('E',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('A',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('R',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('-',  Console.T_PROG));
	entries.addElement(new ConsoleEntry('\n', Console.T_PROG));
	entries.addElement(new ConsoleEntry('\n', Console.T_PROG));

	row0 = 0;
	last_row = nrows - 1;
	sbar.setValues(0, nrows, 0, last_row);

	first_element = entries.size();
	draw_all(true);
	}

/*------------------------------------------------------*/
synchronized	void	write_file(FileOutputStream dest) throws IOException
/*------------------------------------------------------*/
	{
	int	c = 0;
	int	len = entries.size();
	for (int i = 0; i < len; i++)
		{
		ConsoleEntry ce = (ConsoleEntry) entries.elementAt(i);
		if (ce.c == '\n' || c >= ncols)
			{
			dest.write('\n');
			c = 0;
			}
		else
			{
			dest.write(ce.c);
			c++;
			}
		}
	}

	/*********************/
	/*  Private Methods  */
	/*********************/

/*
 *  There are two reasons for adjusting the scroll position when drawing
 *  a character.  Firstly, the number of rows in the console has increased
 *  and we would be writing past the bottom of the window.  Secondly, the
 *  user may have scrolled back, and we need to go forward again.
 */

/*----------------------------------------------*/
private	synchronized	void	check_scrolling()
/*----------------------------------------------*/
	{
	if (row >= last_row)	// First reason
		{
		last_row = row + nrows / 2;
		row0 = last_row - nrows + 1;
		sbar.setValues(row0, nrows, 0, last_row);
		draw_all(true);
		}

	else if (row - row0 > nrows)	// Second reason
		{
		row0 = last_row - nrows + 1;
		sbar.setValue(row0);
		draw_all(true);
		}
	}

/*------------------------------------------*/
private	void	draw_all(boolean clear_first)
/*------------------------------------------*/
	{
	if (clear_first)
		{
		Graphics	g = canvas.getGraphics();
		Dimension	d = canvas.getSize();
		g.clearRect(0, 0, d.width, d.height);
		}

	row = 0;
	col = 0;
	int	len = entries.size();
	for (int i = first_element; i < len; i++)
		{
		ConsoleEntry ce = (ConsoleEntry) entries.elementAt(i);
		draw_char(ce.c, ce.t);
		}

	if (prompt)
		draw_char(prompt_char, Console.T_PROMPT);
	}

/*---------------------------------------*/
private	void	draw_char(int c, int type)
/*---------------------------------------*/
	{
		// a newline character
	if (c == '\n')
		{
		row++;
		col = 0;
		return;
		}

		// check line wrap
	if (col >= ncols)
		{
		row++;
		col = 0;
		}

	just_draw_char(c, type_colour[type]);
	col++;
	}

/*-------------------------------*/
private	void	undraw_char(int c)
/*-------------------------------*/
	{
	col--;

		// reverse line wrap if necessary
	if (col < 0)
		{
		col = ncols - 1;
		row--;
		}

	just_draw_char(c, canvas.getBackground());
	}

/*------------------------------------------------*/
private	void	just_draw_char(int c, Color colour)
/*------------------------------------------------*/
	{
		// draw the character
	int	x = (col + 1) * char_width;
	int	y = (row - row0 + 1) * char_height;
	by[0] = (char) c;
	Graphics	g = canvas.getGraphics();
	g.setColor(colour);
	g.drawChars(by, 0, 1, x, y);
	}

	}
