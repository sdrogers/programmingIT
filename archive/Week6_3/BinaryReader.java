/**
 Class to illustrate reading from a file using
 the read method of the FileInputStream class
 */

import java.io.*;

public class BinaryReader
{
	public static void main(String[] args)
	{
		FileInputStream inputStream = null;
		try {
			try {
				// open file test-in.txt
				inputStream = new FileInputStream("test-in.txt");
				// flag indicating whether finished reading
				boolean done = false;
				while (!done) {
					// read a byte, represented by an int
					int next = inputStream.read();
					// -1 represents end of file
					if (next == -1)
						done = true;
					else {
						// convert to byte
						byte b = (byte) next;
						// echo byte to user
						System.out.print(b+" ");
					}
				}
			}
			finally {
				// executed whether or not an exception is raised above
				System.out.println("The end");
				// close file assuming it was successfully opened
				if (inputStream  != null) inputStream.close();
			}
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
	}
}
