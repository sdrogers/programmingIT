/*
 *	StandardIn.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/30 16:36:05 $
 *	$Revision: 1.3 $
 */

package FormatIO;

import	java.io.*;

/**
 *  This is a formatted interface to System.in
 *  Type Control-D to generate an end of file.
 *  End of File does not throw an exception, you must test 
 *  with the eof method.
 */

/*=============================================================*/

	public	class	StandardIn	extends FormatInNoX

/*=============================================================*/
	{

/*-------------------------------*/
protected	int	get_char()	//throws EofX
/*-------------------------------*/
	{
	try
		{
		int	c = System.in.read();

		if (c == -1)
			{
			set_eof();
//			throw new EofX();
			}

		return c;
		}

	catch (IOException x)
		{
		System.err.println("\n*** StandardIn: Can't read from input");
		System.exit(0);
		}

	return 4;	// keeps the compiler happy
	}

	}
