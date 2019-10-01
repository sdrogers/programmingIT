/*
 *	NFX.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 16:23:47 $
 *	$Revision: 1.3 $
 *
 *	Number Format Exception.
 *	Not exported from the package.
 */

package	FormatIO;

/*===================================*/
public	class	NFX extends Exception
/*===================================*/
	{
private	String	text;
public	String	toString()	{ return text; }
public	NFX(String t)	{ text = new String(t); }
	}
