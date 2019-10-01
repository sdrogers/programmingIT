/*
 *	Format.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/09/01 13:32:10 $
 *	$Revision: 1.2 $
 */

package FormatIO;

/**
 *  This class has a series of static methods to format numbers
 *  and strings.
 *  There are no instance methods, and hence no need to create any
 *  Format objects.  javadoc will add in a null constructor anyway,
 *  please ignore.
 */
/*==================================*/
/*                                  */
	public	class	Format
/*                                  */
/*==================================*/
	{
		// Make sure these conform to other standards
		/** Constant signifying Left Justification */
        public  final   static  int     LEFT     = 1;
		/** Constant signifying Right Justification */
        public  final   static  int     RIGHT    = 2;
		/** Constant signifying Central Justification */
        public  final   static  int     CENTER   = 3;
		/** Constant signifying Standard Justification */
        public  final   static  int     STANDARD = 4;   // left for strings,
                                                        // right for numbers


	/** The input string is interpreted as a double */
/*---------------------------------------------------------------------*/
public	static	String	formatDouble(String s, int width, int precision,
		int jstyle, int fill)
/*---------------------------------------------------------------------*/
	{
	int	slen = s.length();
/*
 *  Check if an E in the format.
 */
	for (int j = 0; j < slen; j++)
		if (s.charAt(j) == 'E' || s.charAt(j) == 'e')
			return formatDoubleE(s, width, precision, jstyle, fill);
/*
 *  Extract the strings before and after the .
 */
	int	size = (slen > precision) ? slen : precision;
	byte[]	a = new byte[size + 1];	// chars before . and also .
	byte[]	b = new byte[size];	// chars after .
	int	i = 0, na = 0, nb = 0;
	for (; i < slen && s.charAt(i) != '.'; i++)
		a[na++] = (byte) s.charAt(i);
	i++;	// skip the '.'
	for (; i < slen; i++)
		b[nb++] = (byte) s.charAt(i);
/*
 *  Deal with precision.
 */
	if (nb > precision)	// round up
		{
		if (b[precision] >= '5')
			if (round_up(b, precision))
				if (round_up(a, na)) // round up -> extra digit
					{
					for (i = na - 1; i >= 0; i--)
						a[i+1] = a[i];
					a[0] = (byte)'1';
					na++;
					}
		nb = precision;
		}

	else if (nb < precision)	// fill with 0's
		{
		for (; nb < precision; nb++)
			b[nb] = (byte)'0';
		}
/*
 *  Put both bits together.
 */
	a[na++] = (byte)'.';
	String	t = new String(a, 0, 0, na) + new String(b, 0, 0, nb);
	if (jstyle == STANDARD)
		jstyle = RIGHT;
	return formatString(t, width, jstyle, fill);
	}

/*----------------------------------------------------------------------*/
private	static	String	formatDoubleE(String s, int width, int precision,
		int jstyle, int fill)
/*----------------------------------------------------------------------*/
	{
	int	slen = s.length();
/*
 *  Extract the strings before and after the E
 */
	byte[]	a = new byte[slen];	// chars before E
	byte[]	b = new byte[slen];	// chars after and including E
	int	i = 0, na = 0, nb = 0;
	for (; i < slen && s.charAt(i) != 'E' && s.charAt(i) != 'e'; i++)
		a[na++] = (byte) s.charAt(i);
	for (; i < slen; i++)
		b[nb++] = (byte) s.charAt(i);
/*
 *  Format first part in normal way, with precision reduced by E part.
 */
	String	front = new String(a, 0, 0, na);
	String	back  = new String(b, 0, 0, nb);
	return formatDouble(front, width - nb, precision, jstyle, fill)
		+ back;
	}

	/** The input string is interpreted as an int */
/*----------------------------------------------------------------------------*/
public	static	String	formatInteger(String s, int width, int jstyle, int fill)
/*----------------------------------------------------------------------------*/
	{
	if (jstyle == STANDARD)
		jstyle = RIGHT;
	return formatString(s, width, jstyle, fill);
	}

	/** Justification with fill characters added to string */
/*----------------------------------------------------------------------------*/
public	static	String	formatString(String s, int width, int jstyle, int fill)
/*----------------------------------------------------------------------------*/
	{
	if (s.length() >= width)
		return s;
	if (jstyle == STANDARD)
		jstyle = LEFT;

	int	pad = width - s.length();
	switch (jstyle)
		{
	case LEFT:
		return s + slen(pad, fill);
	case CENTER:
		return slen(pad/2, fill) + s + slen(pad - pad/2, fill);
	case RIGHT:
		return slen(pad, fill) + s;
		}
	return s;	// just in case, keeps compiler happy
	}

/*------------------------------------------*/
private	static	String	slen(int n, int fill)
	// returns n length string of fill chars
/*------------------------------------------*/
	{
	char[]	a = new char[n];
	for (int i = 0; i < n; i++)
		a[i] = (char) fill;
	return new String(a);
	}

/*----------------------------------------------*/
private	static	boolean	round_up(byte[] b, int n)
/*----------------------------------------------*/
	{
	for (int i = n-1; i >= 0; i--)
		{
		if (b[i] == '9')
			{
			b[i] = (byte)'0';
			}
		else
			{
			b[i]++;
			return false;
			}
		}

	return true;
	}

	}
