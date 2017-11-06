/**
 Class to illustrate reading lines from a file using the Scanner class
 and writing lines to a file using the PrintWriter class.
 Numbers the lines of a given input file and writes to a given output file
 */

import java.io.*;
import java.util.*;

public class LineNumberer
{
	public static void main(String[] args)
	{
		// create Scanner object to read from the keyboard 
		Scanner console = new Scanner(System.in);

		// prompt the user for the name of the input file 
		System.out.print("Input file: ");
		String inputFileName = console.next();

		// prompt the user for the name of the output file 
		System.out.print("Output file: ");
		String outputFileName = console.next();

		FileReader reader = null;
		PrintWriter out = null;
		
		try 
		{
			try {
				// try to open input file
				reader = new FileReader(inputFileName);
				// create a scanner object from reader
				Scanner in = new Scanner(reader);
				// open output file
				out = new PrintWriter(outputFileName);
				int lineNumber = 1;
				// loop as long as there are more lines in the input file
				while (in.hasNextLine())
				{
					// read next line from input file
					String line = in.nextLine();
					// number the line (using a comment) and output this data
					out.print("/* " + lineNumber + " */ ");
					// output the line read from the input file
					out.println(line);
					lineNumber++;
				}
			}
			finally {
				// close the input file assuming it was successfully opened
				if (reader != null) reader.close();
				// close the output file assuming it was successfully opened
				if (out != null) out.close();
			}
		}
		catch (IOException exception)
		{
			// error processing either input or output file
			System.out.println("Error processing file: " + exception);
		}
	}
}
