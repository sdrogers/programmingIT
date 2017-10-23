/*
 *	FormatInNoX.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/03 10:51:30 $
 *	$Revision: 1.4 $
 *
 *	Catch  Number Format, throws EofX exceptions.
 */

package FormatIO;

/*=====================================*/
class	FormatInNoX	extends	FormatIn
/*=====================================*/
	{

public	boolean	readBoolean()	//throws EofX
	{
 { return super.readBoolean(); }
//	catch (NFX e) { System.err.println(e.toString()); }
//	return true;	// keeps compiler happy
	}

public	double	readDouble()	//throws EofX
	{
   { return super.readDouble(); }
//	catch (NFX e) { System.err.println(e.toString()); }
//	return 1.0;	// keeps compiler happy
	}

public	int	readInt()	//throws EofX
	{
  { return super.readInt(); }
//	catch (NFX e) { System.err.println(e.toString()); }
//	return 1;	// keeps compiler happy
	}

	}
