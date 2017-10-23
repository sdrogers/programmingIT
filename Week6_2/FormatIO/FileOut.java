/*
 *	FileOut.java
 *	==============
 *      Copyright (C) 1999, Ron Poet, Dept. Comp.Sci. Uni Glasgow Scotland
 *	$Author: ron $
 *	$Date: 1999/08/23 11:07:08 $
 *	$Revision: 1.1 $
 */

package FormatIO;

import	java.io.*;
import	java.awt.*;


/**
 *  This is an output file.  The name of the file can be provided as an
 *  argument to the constructor.  Alternatively, the null constructor
 *  can be used, which will prompt for the file name using a FileDialog.
 */

/*============================================================*/

	public	class	FileOut	extends FormatOutput

/*============================================================*/
	{
/*
 * Data
 */
	private	FileOutputStream	dest;

        /** Opens a dialog box for file name selection.  */
/*--------------*/
public	FileOut()	// Dialog to get file name
/*--------------*/
	{
	Frame	frame = new Frame();
	FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
	dialog.resize(480, 240);
	dialog.show();
	String	file_name = dialog.getDirectory() + dialog.getFile();
	if (!file_name.equals("nullnull"))
		open(file_name);
	else
		{
		System.err.println("\n*** FileOut: No file name provided!");
		System.exit(0);
		}

	frame.dispose();
	}

        /** The named file is opened. */
/*-------------------------*/
public	FileOut(String name)
/*-------------------------*/
	{
	open(name);
	}

/*------------------------------*/
private	void	open(String name)
/*------------------------------*/
	{
	try
		{
		dest = new FileOutputStream(name);
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileOut: Can't open output file "
			+ name);
		System.exit(0);
		}
	}

        /** Files should be closed when no longer needed. */
/*--------------------*/
public	void	close()
/*--------------------*/
	{
	try
		{
		dest.close();
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileOut: Can't close output file ");
		System.exit(0);
		}
	}

	/********************/
	/*  Output Routine  */
	/********************/

/*-------------------------------------*/
protected	void	put_char(char c)
/*-------------------------------------*/
	{
	try
		{
		dest.write((int) c);
		}

	catch(IOException x)
		{
		System.err.println("\n*** FileOut: Can't print output ");
		System.exit(0);
		}
	}

	}
