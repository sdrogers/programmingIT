/**
 Class to read in lines of a file using the Scanner class
 */

import java.io.*;
import java.util.*;

public class LineReader
{
	public static void main(String[] args)
	{
		try {
			FileReader reader = new FileReader("test-in.txt");
			// create a Scanner object from the reader
			Scanner in = new Scanner(reader);
			while (in.hasNextLine()) { // more lines to read
				// read next line from the input file
				String line = in.nextLine();
				// write this line to the console output
				System.out.println(line);
			}
			reader.close();
		}catch(IOException e) {
			// Problem with the file
		}
		
	}
}
