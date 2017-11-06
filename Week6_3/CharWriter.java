import java.io.*;

/**
 Class to illustrate writing to a file using 
 the write method of FileWriter
 */

public class CharWriter
{
	public static void main(String[] args)
	{
		FileWriter writer = null;
		try {
			try {
				// open test-out.txt for writing
				writer = new FileWriter("test-out.txt");
				// write four characters to the file
				writer.write('t');
				writer.write('e');
				writer.write('s');
				writer.write('t');
			}
			finally {
				// executed whether or not an exception is raised above
				// close the file assuming it was successfully opened
				if (writer  != null) writer.close();
			}
		}
		catch (IOException e) {
			System.out.println("File error");
		}
		
	}
}
