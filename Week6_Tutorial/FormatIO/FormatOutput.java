/*
 *	FormatOutput.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/30 13:23:55 $
 *	$Revision: 1.2 $
 */

package FormatIO;

import	java.io.*;
import	java.awt.*;


/*============================================*/

	public	class	FormatOutput

/*============================================*/
	{
/*
 * Data
 */
	private	int	width = 0;	// uses as much space as it needs
	private	int	precision = 4;	// number of decimal places
	private	int	fill = ' ';	// fill character
	private	int	jstyle = Format.STANDARD;

	/*  This method must be overloaded by all child classes  */

/*-------------------------------------*/
protected	void	put_char(char c)
/*-------------------------------------*/
	{
	System.err.println("FormatOutput::put_char");
	}

	/******************************************/
	/*  Actual output methods,                */
	/*  conforming to the PrintStream style.  */
	/******************************************/

/*--------------------------*/
public	void	print(char c)
/*--------------------------*/
	{
	char[]	a = new char[1];
	a[0] = (char) c;
	String s = new String(a);
	print(s);
	}

/*----------------------------*/
public	void	print(double d)
/*----------------------------*/
	{
	String	s = Double.toString(d);
	s = Format.formatDouble(s, width, precision, jstyle, fill);
	print(s);
	}

/*-------------------------*/
public	void	print(int i)
/*-------------------------*/
	{
	String	s = Integer.toString(i);
	s = Format.formatInteger(s, width, jstyle, fill);
	print(s);
	}

/*----------------------------*/
public	void	print(String s)
/*----------------------------*/
	{
	s = Format.formatString(s, width, jstyle, fill);

		// now output the individual characters
	for (int i = 0; i < s.length(); i++)
		put_char(s.charAt(i));
	}

/*-----------------------------*/
public	void	print(boolean b)
/*-----------------------------*/
	{
	String	s = (b) ? Format.formatString("True",  width, jstyle, fill)
	                : Format.formatString("False", width, jstyle, fill);
	print(s);
	}

/*
 *  java will automatically convert a long to a double rather than an int!!!!
 *  hence the following method.
 */

public	void	print(long i)	{ print((int)i); }

/*
 *  ..ln versions
 */

public	void	println(char c)		{ print(c); put_char('\n'); }
public	void	println(double d)	{ print(d); put_char('\n'); }
public	void	println(int i)		{ print(i); put_char('\n'); }
public	void	println(String s)	{ print(s); put_char('\n'); }
public	void	println(boolean b)	{ print(b); put_char('\n'); }
public	void	println()		{ put_char('\n'); }
public	void	println(long i)		{ println((int)i); }

	/**********************************************/
	/*  print commands with intrinsic formatting  */
	/**********************************************/

private	void	restore()	// back to default values
	{ width = 0; precision = 4; fill = ' '; jstyle = Format.STANDARD; }

public	void	print(char c, int width, int fill, int style)
	{ setWidth(width); setFill(fill); setJustification(style); print(c);
	restore(); }
public	void	print(char c, int width, int fill)
	{ setWidth(width); setFill(fill); print(c); restore(); }
public	void	print(char c, int width)
	{ setWidth(width); print(c); restore(); }

public	void	print(double d, int width, int prec, int fill, int style)
	{ setWidth(width); setPrecision(prec); setFill(fill);
	setJustification(style); print(d); restore(); }
public	void	print(double d, int width, int prec, int fill)
	{ setWidth(width); setPrecision(prec); setFill(fill); print(d);
	restore(); }
public	void	print(double d, int width, int prec)
	{ setWidth(width); setPrecision(prec); print(d); restore(); }
public	void	print(double d, int width)
	{ setWidth(width); print(d); restore(); }

public	void	print(int i, int width, int fill, int style)
	{ setWidth(width); setFill(fill); setJustification(style); print(i);
	restore(); }
public	void	print(int i, int width, int fill)
	{ setWidth(width); setFill(fill); print(i); restore(); }
public	void	print(int i, int width)
	{ setWidth(width); print(i); restore(); }

public	void	print(String s, int width, int fill, int style)
	{ setWidth(width); setFill(fill); setJustification(style); print(s);
	restore(); }
public	void	print(String s, int width, int fill)
	{ setWidth(width); setFill(fill); print(s); restore(); }
public	void	print(String s, int width)
	{ setWidth(width); print(s); restore(); }

public	void	print(boolean b, int width, int fill, int style)
	{ setWidth(width); setFill(fill); setJustification(style); print(b);
	restore(); }
public	void	print(boolean b, int width, int fill)
	{ setWidth(width); setFill(fill); print(b); restore(); }
public	void	print(boolean b, int width)
	{ setWidth(width); print(b); restore(); }

public	void	print(long i, int width, int fill, int style)
	{ print((int)i, width, fill, style); }
public	void	print(long i, int width, int fill)
	{ print((int)i, width, fill); }
public	void	print(long i, int width)
	{ print((int)i, width); }

/*
 *  ..ln versions
 */

public	void	println(char c, int width, int fill, int style)
	{ print(c, width, fill, style); put_char('\n'); }
public	void	println(char c, int width, int fill)
	{ print(c, width, fill); put_char('\n'); }
public	void	println(char c, int width)
	{ print(c, width); put_char('\n'); }

public	void	println(double d, int width, int prec, int fill, int style)
	{ print(d, width, prec, fill, style); put_char('\n'); }
public	void	println(double d, int width, int prec, int fill)
	{ print(d, width, prec, fill); put_char('\n'); }
public	void	println(double d, int width, int prec)
	{ print(d, width, prec); put_char('\n'); }
public	void	println(double d, int width)
	{ print(d, width); put_char('\n'); }

public	void	println(int i, int width, int fill, int style)
	{ print(i, width, fill, style); put_char('\n'); }
public	void	println(int i, int width, int fill)
	{ print(i, width, fill); put_char('\n'); }
public	void	println(int i, int width)
	{ print(i, width); put_char('\n'); }

public	void	println(String s, int width, int fill, int style)
	{ print(s, width, fill, style); put_char('\n'); }
public	void	println(String s, int width, int fill)
	{ print(s, width, fill); put_char('\n'); }
public	void	println(String s, int width)
	{ print(s, width); put_char('\n'); }

public	void	println(boolean b, int width, int fill, int style)
	{ print(b, width, fill, style); put_char('\n'); }
public	void	println(boolean b, int width, int fill)
	{ print(b, width, fill); put_char('\n'); }
public	void	println(boolean b, int width)
	{ print(b, width); put_char('\n'); }

public	void	println(long i, int width, int fill, int style)
	{ println((int)i, width, fill, style); }
public	void	println(long i, int width, int fill)
	{ println((int)i, width, fill); }
public	void	println(long i, int width)
	{ println((int)i, width); }

	/********************/
	/*  Format Commands */
	/********************/

public	int	setWidth(int w)
	{ int oldw = width; width = w; return oldw; }

public	int	setPrecision(int p)
	{ int oldp = precision; precision = p; return oldp; }

public	int	setFill(int f)
	{ int oldf = fill; fill = f; return oldf; }

public	int	setLeft()	// left justify, returns previous
	{ int oldj = jstyle; jstyle = Format.LEFT; return oldj; }

public	int	setRight()
	{ int oldj = jstyle; jstyle = Format.RIGHT; return oldj; }

public	int	setCenter()
	{ int oldj = jstyle; jstyle = Format.CENTER; return oldj; }

public	int	setStandard()
	{ int oldj = jstyle; jstyle = Format.STANDARD; return oldj; }

public	int	setJustification(int j)	// set a value returned by previous
	{ int oldj = jstyle; jstyle = j; return oldj; }

	/*****************************************/
	/*  Conforming to the DataOutput style,  */
	/*  which matches that of DataInput      */
	/*****************************************/

public	void	writeChar(char c, int w, int f, int j)
	{ print(c, w, f, j); }
public	void	writeChar(char c, int w, int f)
	{ print(c, w, f); }
public	void	writeChar(char c, int w)
	{ print(c, w); }
public	void	writeChar(char c)
	{ print(c); }

public	void	writeDouble(double d, int w, int p, int f, int j)
	{ print(d, w, p, f, j); }
public	void	writeDouble(double d, int w, int p, int f)
	{ print(d, w, p, f); }
public	void	writeDouble(double d, int w, int p)
	{ print(d, w, p); }
public	void	writeDouble(double d, int w)
	{ print(d, w); }
public	void	writeDouble(double d)
	{ print(d); }

public	void	writeInt(int i, int w, int f, int j)
	{ print(i, w, f, j); }
public	void	writeInt(int i, int w, int f)
	{ print(i, w, f); }
public	void	writeInt(int i, int w)
	{ print(i, w); }
public	void	writeInt(int i)
	{ print(i); }

public	void	writeString(String s, int w, int f, int j)
	{ print(s, w, f, j); }
public	void	writeString(String s, int w, int f)
	{ print(s, w, f); }
public	void	writeString(String s, int w)
	{ print(s, w); }
public	void	writeString(String s)
	{ print(s); }

public	void	writeBoolean(boolean b, int w, int f, int j)
	{ print(b, w, f, j); }
public	void	writeBoolean(boolean b, int w, int f)
	{ print(b, w, f); }
public	void	writeBoolean(boolean b, int w)
	{ print(b, w); }
public	void	writeBoolean(boolean b)
	{ print(b); }

	}
