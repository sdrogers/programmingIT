import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LabEx2 {

	public static void readAndPrint(String fileName) {
		FileReader fr = null;
		try {
			// make a filereader object
			fr = new FileReader(fileName);
			// make a scanner around the filereader
			Scanner s = new Scanner(fr);
			// Loop until no lines left
			while (s.hasNextLine()) {
				// get the next line
				String line = s.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// close the file, if it's open
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void readAndCalculate(String fileName) {
		String results = "";
		FileReader fReader = null;
		try {
			// make a filereader object
			fReader = new FileReader(fileName);
			// make a scanner around the filereader
			Scanner s = new Scanner(fReader);
			// Loop until no lines left
			Scanner lineScanner = null;
			while (s.hasNextLine()) {
				// get the next line
				String line = s.nextLine();
				lineScanner = new Scanner(line);
				int a = lineScanner.nextInt();
				String op = lineScanner.next();
				int b = lineScanner.nextInt();
				int c;
				if (op.equals("+"))
					c = a + b;
				else
					c = a - b;
				results += line + " result: " + c + "\n";

			}
			System.out.println(results);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// close the file, if it's open
			if (fReader != null) {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * this version uses the FileReader.read() method as instructed
	 */
	public static String readAndReverse1(String fileName) {
		FileReader fReader = null;
		char[] chars = new char[1000];
		String resultString = "";
		int stringLen = 0;
		try {
			// make a filereader object
			fReader = new FileReader(fileName);

			boolean stopReading = false;
			while (!stopReading) {
				
				int nextInt = fReader.read();
				if (nextInt != -1) {
					chars[stringLen] = (char) nextInt;
					stringLen++;
				}

				else
					stopReading = true;

			}
		} catch (IOException e) {
			System.out.println("There's a problem accessing the file");
		}

		finally {
			// close the file, if it's open
			if (fReader != null) {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// now stringLen is the length of the string

		for (int i = 0; i < stringLen; i++) {
			resultString = resultString + chars[stringLen - 1 - i];
		}

		return resultString;
	}

	/*
	 * this version doesn't use the FileReader.read method
	 */
	public static String readAndReverse2(String fileName) {
		FileReader fReader = null;
		String resultString = "";
		try {
			// make a filereader object
			fReader = new FileReader(fileName);
			// make a scanner around the filereader
			Scanner s = new Scanner(fReader);
			// Loop until no lines left
			String line = s.nextLine();
			// split using the comma
			char[] chars = new char[1000];
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				chars[i] = c;
			}
			for (int i = 0; i < line.length(); i++) {
				resultString = resultString + chars[line.length() - 1 - i];
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// close the file, if it's open
			if (fReader != null) {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return resultString;
	}

	public static void writeToFile(String text, String fileName) {

		FileWriter fWriter = null;
		try {
			// Create a FileWriter object
			fWriter = new FileWriter(fileName);
			fWriter.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Attempt to close the file
			if (fWriter != null) {
				try {
					fWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
        // you'll need to add your own file paths to the files!!
        
        // comment/uncomment the lines to test each of the methods
        
        
		readAndPrint("/Users/alice/javaFiles/progIT/progIT/src/week5_Exceptions_FileIO/dolphin.txt");
		readAndCalculate("/Users/alice/javaFiles/progIT/progIT/src/week5_Exceptions_FileIO/sums.txt");
        
        
		String text = readAndReverse1("/Users/alice/javaFiles/progIT/progIT/src/week5_Exceptions_FileIO/backwards.txt");
        //String text = readAndReverse1("/Users/alice/javaFiles/progIT/progIT/src/week5_Exceptions_FileIO/backwards.txt");
        
		writeToFile(text,
				"/Users/alice/javaFiles/progIT/progIT/src/week5_Exceptions_FileIO/output.txt");

	}

}
