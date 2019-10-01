/*
 *	StringOut.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/23 11:07:08 $
 *	$Revision: 1.1 $
 *
 *	Based on StringBuffer
 */

package FormatIO;

import	java.io.*;

/*====================================================================*/

	public	class	StringOut	extends FormatOutput

/*====================================================================*/
	{
	private	StringBuffer	string;	// our own private copy of the string

/*------------------------------*/
public	StringOut(StringBuffer s)
/*------------------------------*/
	{
	string = s;
	}

/*-------------------------------------*/
protected	void	put_char(char c)
/*-------------------------------------*/
	{
	string.append(c);
	}

	}
