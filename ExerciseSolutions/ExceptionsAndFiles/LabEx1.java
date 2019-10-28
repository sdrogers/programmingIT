import java.util.InputMismatchException;
import java.util.Scanner;

public class LabEx1 {

	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		boolean ok = false;
		Scanner lineScanner;
		while(!ok){
			System.out.println("Input an integer");
			String line = myScanner.next();
			lineScanner = new Scanner(line);
			try {
				lineScanner.nextInt();
				ok = true;
			}catch(InputMismatchException e) {
				System.out.println("That's not an integer!");
			}
		
			lineScanner.close();
		}
		
		myScanner.close();
		System.out.println("program finished");
		
	}

}
