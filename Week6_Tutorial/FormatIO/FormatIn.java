/*
 *	FormatIn.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 16:23:47 $
 *	$Revision: 1.6 $
 *
 *	Throws Number Format and Eof Exceptions.
 *	This class is internal to the package.
 *	Implements the interface in terms of its own abstract method
 *	get_char
 */

package FormatIO;

/*=====================*/
	class	FormatIn
/*=====================*/
		implements	FormatInput
	{

	/**********/
	/*  Data  */
	/**********/

private	int	peek_char;	// last character read
private	boolean	have_peeked = false;
private	boolean	is_eof = false;
private	String	white = " \t\n";

	/*****************************************/
	/*  Our abstract method                  */
	/*  Must be implemented by all children  */
	/*****************************************/

/*-------------------------------*/
protected	int	get_char()	//throws EofX	
/*-------------------------------*/
	{ return '?'; }

	/***********************************/
	/*  Implement FormatInput methods  */
	/***********************************/

/*---------------------------------*/
public	String	setWhite(String wsc)
/*---------------------------------*/
	{
	String	old = white;
	white = new String(wsc);	// make our own copy
	return old;
	}


/*--------------------------*/
public	boolean	readBoolean()	//throws EofX, NFX
/*--------------------------*/
	{
	String	w = readWord();
	String	s = w.toLowerCase();
	if (s.equals("true"))
		return true;
	if (s.equals("false"))
		return false;

	else
		return false;
	//throw new NFX("\n"+w+" is not a boolean\n");
	}

/*-----------------------*/
public	char	readChar()	//throws EofX
/*-----------------------*/
	{
	skip_white();
	return (char) read_char();
	}

/*-------------------------*/
public	double	readDouble()	//throws EofX, NFX
/*-------------------------*/
	{
	skip_white();
	String	s = read_yes("+-0123456789.").toString();
        if (s.length() == 0)
                s = readWord(); // not a number, read and clear rubbish

	try
		{
		Double	d = new Double(s);
		return d.doubleValue();
		}

	catch (NumberFormatException e)
		{
//		throw new NFX("\n"+s+" is not a double\n");
		}
	return 0.0;
	}

/*----------------------*/
public	int	readInt()	//throws EofX, NFX
/*----------------------*/
	{
	skip_white();
	String	s = read_yes("+-0123456789.").toString();
        if (s.length() == 0)
                s = readWord(); // not a number, read and clear rubbish

	try
		{
		Integer	i = new Integer(s);
		return i.intValue();
		}

	catch (NumberFormatException e)
		{
//		throw new NFX("\n"+s+" is not an integer\n");
		}
	return -1;
	}

/*-----------------------*/
public	String	readLine()	//throws EofX
/*-----------------------*/
	{
	skip_white();
	return getLine();
	}

/*-----------------------*/
public	String	readWord()	//throws EofX
/*-----------------------*/
	{
	skip_white();
	return read_no(" \t\n").toString();
	}

/*----------------------*/
public	char	getChar()	//throws EofX
/*----------------------*/
	{
	return (char) read_char();
	}

/*----------------------*/
public	String	getLine()	//throws EofX
/*----------------------*/
	{
	return read_no("\n").toString();
	}

/*-----------------------*/
public	void	skipLine()	//throws EofX
/*-----------------------*/
	{
	read_no("\n");
	read_char();	// get rid of the newline as well.
	}

/*------------------*/
public	boolean	eof()
/*------------------*/
	{
	return is_eof;
	}

	/*********************/
	/*  Private Methods  */
	/*********************/

/*
 *  We can 'unread' one character, which provides a one character
 *  look ahead for methods such as readInteger that stop at the first
 *  non-integer character without appearing to read it.
 *  read_char and unread provide the peek mechanism.
 */

/*------------------------------*/
protected	void	set_eof()
/*------------------------------*/
	{
	is_eof = true;
	}

/*------------------------*/
private	int	read_char()	//throws EofX
/*------------------------*/
	{
	if (have_peeked)
		have_peeked = false;
	else
		peek_char = get_char();

	return peek_char;
	}

/*---------------------*/
private	void	unread()
/*---------------------*/
	{
	have_peeked = true;
	}

/*
 *  read_yes will read all characters that are allowed, stopping at
 *  the first unallowed character, which is unread.
 *  skipping white space is read_yes(" \t\n");
 *
 *  read_no will read all characters that are not disallowed, unreading
 *  the character that stops the process.
 */

/*-----------------------------------------------*/
private	StringBuffer	read_yes(String yes_chars)	//throws EofX
/*-----------------------------------------------*/
	{
	StringBuffer	s = new StringBuffer();

	for (;;)
		{
		char	c = (char) read_char();
		if (yes_chars.indexOf(c) == -1)	// not an acceptable char
			break;
		s.append(c);
		}

	unread();
	return s;
	}

/*---------------------------------------------*/
private	StringBuffer	read_no(String no_chars)	//throws EofX
/*---------------------------------------------*/
	{
	StringBuffer	s = new StringBuffer();

	for (;;)
		{
		char	c = (char) read_char();
		if (no_chars.indexOf(c) != -1) // not an acceptable char
			break;
		s.append(c);
		}

	unread();
	return s;
	}

/*-------------------------*/
private	void	skip_white()	//throws EofX
/*-------------------------*/
	{
	read_yes(white);
	}

	}
