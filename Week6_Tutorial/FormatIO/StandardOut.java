/*
 *	StandardOut.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/23 11:07:08 $
 *	$Revision: 1.1 $
 */

package FormatIO;

import	java.io.*;


/**
 *  This is a formatted interface to System.out
 */

/*====================================================================*/

	public	class	StandardOut	extends FormatOutput

/*====================================================================*/
	{

/*-------------------------------------*/
protected	void	put_char(char c)
/*-------------------------------------*/
	{
	System.out.write((int) c);
	System.out.flush();
	}

	}
