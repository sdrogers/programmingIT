import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2 {

	public static void main(String[] args) {
		boolean inputOk = false;
		Scanner s = new Scanner(System.in);
		while(!inputOk) {
			System.out.println("Enter something");
			String line = s.nextLine();
			Scanner t = new Scanner(line);
			try {
				int a = t.nextInt();
				inputOk = true; // only get to this line if the previous one was successful
			}catch(InputMismatchException e) {
				System.out.println("Enter an integer");
			}
		}
		System.out.println("Well done!");
	}

}
