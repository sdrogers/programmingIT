import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sums {

	public static void main(String[] args) {
		FileReader reader = null;
		String fileName = "sums.txt";
		try {
			reader = new FileReader(fileName);
			Scanner s = new Scanner(reader);
			while(s.hasNextLine()) {
				// Get the line
				String line = s.nextLine();
				Scanner t = new Scanner(line);
				// get the first integer
				int firstInt = t.nextInt();
				// get the operator
				String operator = t.next();
				// get the second operator
				int secondInt = t.nextInt();
				int result;
				// do the calculation
				if(operator.equals("+")) {
					result = firstInt + secondInt;
				}else {
					result = firstInt - secondInt;
				}
				System.out.println(line + " = " + result);
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
	}

}
