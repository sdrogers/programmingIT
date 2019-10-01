/*
 *	StringIn.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 16:23:47 $
 *	$Revision: 1.4 $
 */

package FormatIO;

import	java.io.*;

/**
 *  This is a formatted interface to a String.
 *  End of String will throw an EofX exception.
 *  It is NOT called EosX, for consisstancy with
 *  other FormatIO classes.
 *
 *  If thew string is not terminated with a white space character,
 *  then one is appended, to avoid problems such as generating EofX
 *  when trying to find the end of the last int in the string.
 */

/*=====================================================*/

public	class	StringIn	extends FormatInNoX

/*=====================================================*/
	{
	private	String	string;	// our own private copy of the string
	private	int	i;	// current 'read' position
	private	int	len;
	private	boolean	not_terminated;

/*-----------------------*/
public	StringIn(String s)
/*-----------------------*/
	{
	string = new String(s);
	i = 0;
	len = string.length();
	int	c = (int) string.charAt(len - 1);
	if (c != ' ' && c != '\t' && c != '\n')
		not_terminated = true;
	else
		not_terminated = false;
	}

/*-------------------------------*/
protected	int	get_char()	//throws EofX
/*-------------------------------*/
	{
	if (i == len && not_terminated)
		{
		set_eof();
		i++;
		return '\n';
		}

	else if (i > len)
		{
		set_eof();
//		throw new EofX();
		}

	else
		{
		i++;
		return (int) string.charAt(i-1);
		}
	return -1;
	}

	}
