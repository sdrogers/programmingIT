/**
 Class to illustrate reading from a file using Scanner
 */

import java.io.*;
import java.util.*;

public class IntReader
{
	public static void main(String[] args) 
	{
		FileReader reader = null;
		try {
			try {
				// open file test-in.txt for reading
				reader = new FileReader("test-in2.txt");
				// create a scanner from the read object
				Scanner in = new Scanner(reader);
				// try to read in 10 integers
				for (int i=1; i<=10; i++) {
					int test = in.nextInt();
					// confirm input back to user
					System.out.println(test);
				}

			}
			catch (InputMismatchException e) {
				// report input error to user
				System.out.println("There were not 10 integers in the file!");
			}
			catch (IOException e) {
				// there was an error opening the file
				System.out.println("File not found");
			}finally {
				// executed whether or not an exception is raised above
				System.out.println("The end");
				// close the file assuming it was successfully opened
				if (reader != null) reader.close();
			}
		}catch(Exception e) {}
	}
}
