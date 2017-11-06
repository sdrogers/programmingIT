/**
 * Demonstrates use of the StringBuilder class
 */

import java.io.*;
import java.util.*;

public class TestSB
{
	public static void main(String[] args)
	{
		final String queryString = "be";
		final String replaceString = "pass";
		try
		{	FileReader fr = null;
		try
		{       // open input file and create a scanner 
			fr = new FileReader("test.txt");
			Scanner in = new Scanner(fr);
			while (in.hasNextLine())
			{
				// read in a line from the input file
				String line = in.nextLine();
				// replaces all occurrences of queryString in line by replaceString
				StringBuilder text = new StringBuilder(line);
				int index = 0;
				while (index != -1 && index<text.length())
				{
					index = text.indexOf(queryString, index);  // next occurrence of fw
					if (index !=-1) // there is another occurrence
					{
						text.replace(index, index+queryString.length(), replaceString);
						index += replaceString.length();
					}		
				}
				System.out.println(text);
			}
		}
		finally
		{ // close file, assuming it was successfully opened
			if (fr!=null) fr.close();
		}
		}
		catch (IOException e)
		{	System.out.println("Exception "+e);
		System.exit(1);
		}
	}
}
