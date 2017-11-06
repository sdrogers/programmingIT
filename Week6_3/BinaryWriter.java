/**
 Class to illustrate writing to a file using the
 write method of FileOutputStream
 */

import java.io.*;

public class BinaryWriter
{
	public static void main(String[] args)
	{
		FileOutputStream outputStream = null;
		try {
			try {
				// open file for output
				outputStream = new FileOutputStream("test-out.txt");
				byte b = (byte) 't';
				outputStream.write(b);
				b = (byte) 'e';
				outputStream.write(b);
				b = (byte) 's';
				outputStream.write(b);
				b = (byte) 't';
				outputStream.write(b);
			}
			finally {
				// executed whether or not an exception is raised above
				System.out.println("The end");
				// close file assuming it was successfully opened
				if (outputStream  != null) outputStream.close();
			}
		}
		catch (IOException e) {
			System.out.println("File error");
		}
		
	}
}