/*
 *	FormatInput.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 16:23:47 $
 *	$Revision: 1.5 $
 */

package FormatIO;

/**
 *  Classes that inherit from this interface support formatted input.
 *
 *  readDouble, readInt, readBoolean, readChar, readWord and readLine
 *  all skip initial whitespace (space, tab or newline).
 *  readInt and readDouble will then stop before the next non numeric
 *  character, while readBoolean, readChar and readWord will stop before
 *  the next white space.  readLine stops before the next newline.
 *
 *  These names conform to the DataInput style.
 *
 *  White space characters are space, tab and newline.
 *
 *  getChar and getLine do not skip initial white space.
 *  getChar will read the next character, even if it is whitespace.
 *  Simlarly, getLine will read all the remaining characters on the line,
 *  including the newline, even if they are whitespace characters.
 *  skipLine is similar to readLine, but discards the characters read.
 *
 *  An EofX exception is thrown if a newline is encountered.
 *  A  NFX  exception is thrown if there is an input format error,
 *  for example, typeing fred when an integer was expected.
 *  The eof method returns true if the end of file has been past.
 *
 *  Child classes may chose to catch these exceptions, and so they
 *  may not be propagated out to the customer code level.
 */

/*================================*/
public	interface	FormatInput
/*================================*/
	{
	// returns previos white space characters
public	String	setWhite(String white_space_characters);

	// These methods skip initial white space
public	boolean	readBoolean()	throws EofX, NFX;
public	char	readChar()	throws EofX;
public	double	readDouble()	throws EofX, NFX;
public	int	readInt()	throws EofX, NFX;
public	String	readLine()	throws EofX;
public	String	readWord()	throws EofX;

	// These methods DO NOT skip initial white space
public	char	getChar()	throws EofX;
public	String	getLine()	throws EofX;

public	void	skipLine()	throws EofX;

public	boolean	eof();
	}
