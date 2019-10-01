/**
 * Demonstrates use of the split method
 */

import java.io.*;
import java.util.*;

public class TestSplit
{
	public static void main(String[] args)
	{
		try
		{	FileReader fr = null;
			try
			{ // open input file and create a scanner 
				fr = new FileReader("testsplit.txt");
				Scanner in = new Scanner(fr);
				// declare array of delimiters to be used for corresponding input file lines
				String [] delimiters = {" ", "[a-zA-Z]+", "[ ,.]+"};
				int lineNum=0;
				while (in.hasNextLine())
				{
				      // read in a line from the input file
					String line = in.nextLine();
					// split up the line into tokens using the relevant delimiter
					String [] tokens = line.split(delimiters[lineNum]);
					// print out the tokens, one by one
					for (int tokenNum = 0; tokenNum < tokens.length; tokenNum++)
						System.out.println("Line "+lineNum+", token "+tokenNum+
								           " is \""+tokens[tokenNum]+"\"");
					System.out.println();
					lineNum++;
				}
			}
			finally
			{ // close file, assuming it was successfully opened
				if (fr!=null) fr.close();
			}
		}
		catch (IOException e)
		{	System.out.println("Exception "+e);
		}
	}
}
