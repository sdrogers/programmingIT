import java.util.Scanner;

public class Question6 {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		// Change these to today's date
		int todayYear = 2019;
		int todayMonth = 10;
		int todayDay = 1;

		System.out.println("Enter your birthday as dd mm yyyy");
		String line = keyboard.nextLine();
		Scanner lineScanner = new Scanner(line);
		int birthDay = lineScanner.nextInt();
		int birthMonth = lineScanner.nextInt();
		int birthYear = lineScanner.nextInt();

		// First compute the difference in years
		int yearsOld = todayYear - birthYear;
		// Subtract one, so it is their age in years at the start of the year
		yearsOld --;
		// If we have gone past their birth month, increment by one
		if(todayMonth > birthMonth) {
			yearsOld ++;
		}else if(todayMonth == birthMonth) {
			if(todayDay >= birthDay) {
				yearsOld ++;
			}
		}
		System.out.println("You are " + yearsOld + " years old.");
	}
}