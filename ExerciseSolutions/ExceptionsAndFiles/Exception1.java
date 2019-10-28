import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		try {
			Scanner t = new Scanner(line);
			int a = t.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("You should have entered an integer!");
		}finally {
			System.out.println("Thanks for your time!");
		}
	}
}
