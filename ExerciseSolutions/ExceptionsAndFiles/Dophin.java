import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dophin {

	public static void main(String[] args) {
		String fileName = "dolphin.txt";
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			Scanner s = new Scanner(reader);
			while(s.hasNextLine()) {
				System.out.println(s.nextLine());
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
