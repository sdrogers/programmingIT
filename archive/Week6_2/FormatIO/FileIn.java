/*
 *	FileIn.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/30 16:36:05 $
 *	$Revision: 1.3 $
 */

package FormatIO;

import	java.io.*;
import	java.awt.*;

/**
 *  This is an input file.  The name of the file can be provided as an
 *  argument to the constructor.  Alternatively, the null constructor
 *  can be used, which will prompt for the file name using a FileDialog.
 *  Attempting to read past the end of file will generate an EofX
 *  exception, which can be caught in the normal way.
 */

/*=====================================================*/

	public	class	FileIn	extends FormatInNoX

/*=====================================================*/
	{
/*
 * Data
 */
	private	String	the_name;
	private	FileInputStream	source;
	private	int	previous_char = '?';
		// for PC style double newline characters

	/** Opens a dialog box for file name selection.  */
/*-------------*/
public	FileIn()
/*-------------*/
	{
	Frame	frame = new Frame();
	FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
	dialog.resize(480, 240);
	dialog.show();
	the_name = dialog.getDirectory() + dialog.getFile();
	if (!the_name.equals("nullnull"))
		open();
	else
		{
		System.err.println("\n*** FileIn: No file name provided!");
		}

	frame.dispose();
	}

	/** The named file is opened. */
/*-----------------------------*/
public	FileIn(String file_name)
/*-----------------------------*/
	{
	the_name = file_name;
	open();
	}

/*-------------------*/
private	void	open()
/*-------------------*/
	{
	try
		{
		source = new FileInputStream(the_name);
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileIn: Can't open input file "
			+ the_name);
		System.exit(0);
		}
	}

	/** Go back to the start of the file. */
/*--------------------*/
public	void	reset()
/*--------------------*/
	{
	close();
	open();
	}

	/** Files should be closed when no longer needed. */
/*--------------------*/
public	void	close()
/*--------------------*/
	{
	try
		{
		source.close();
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileIn: Can't close input file ");
		}
	}

	/*******************/
	/*  Input Routine  */
	/*******************/

/*-------------------------------*/
protected	int	get_char()	//throws EofX
/*-------------------------------*/
	{
	try
		{
/*
 *  We have to be careful with newlines, since unix uses ascii 10,
 *  Mac ascii 13 and PC's ascii 13 followed by ascii 10
 */
		for (;;)	// go round again if a non-newline
				// control character
				// this copes with 
			{
			int	c = source.read();
			if (c == -1)
				{
				set_eof();
//				throw new EofX();
				}

				// This could be a UNIX newline (returned), or
				// the second char of a PC newline (ignored)
			if (c == 10)	// UNIX newline
				{
				if (previous_char == 13)
					continue;
				c = '\n';
				}

			else if (c == 13) // Mac & PC newline
				c = '\n';

			else if (c < 32) // ignore any other control character
				continue;

			previous_char = c;
			return c;	// normally get here
			}
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileIn:Can't read from input file ");
		}

	return '?';	// keeps compiler happy
	}

	}
