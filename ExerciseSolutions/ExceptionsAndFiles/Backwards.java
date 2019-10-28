import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Backwards {

	public static void main(String[] args) {
		FileReader reader = null;
		String fileName = "backwards.txt";
		/*
		 * we'll store the characters in this array
		 * 1000 should be plenty
		 */
		char[] allChars = new char[1000];
		int nChars = 0;
		try {
			reader = new FileReader(fileName);
			while(true) {
				try {
					// The FileReader read method returns ints
					// that can then be cast as characters
					// it returns -1 if we're at the end of the file
					// It can also throw an IOException so we need
					// another try catch block!
					int intChar = reader.read();
					if(intChar == -1) {
						break; // end of file
					}
					/* Store the char in the next position of the array
					 * At this point we cast the int to a char
					 * All chars have an int representation
					 * Uncoment the next line to see the mapping from
					 * ints to chars...
					 */
					//System.out.println(intChar + " = " + (char)intChar);
					allChars[nChars++] = (char)intChar;
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null) {
					reader.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		/* 
		 * if we loaded anything, print it
		 */
		if(nChars > 0) {
			/*
			 *  Print it forwards (just for fun)
			 *  Do this by appending the characters
			 *  one by one to a string
			 */
			
			String line = "";
			for(int i=0;i<nChars;i++) {
				line += allChars[i];
			}
			System.out.println(line);
			/* Print it backwards
			 * Same technique as forward but reverse
			 * the loop
			 */
			line = "";
			for(int i=nChars-1;i>=0;i--) {
				line += allChars[i];
			}
			System.out.println(line);
		}
	}

}
