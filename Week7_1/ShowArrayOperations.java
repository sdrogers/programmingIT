import java.util.*;

public class ShowArrayOperations
{
	public static void main(String[] args)
	{
		final int MAX_LENGTH = 10;
		Scanner in = new Scanner (System.in);
		ArrayOperations arrayOperations = new ArrayOperations(in, MAX_LENGTH); 
		while (true)
		{	
			System.out.println("Enter A to add an element, "+
					"D to delete an element, and Q to quit");
			String choice = in.next();
			switch (choice.charAt(0))
			{       
			case 'A':
				arrayOperations.addElement();
				break;
			case 'D':
				arrayOperations.deleteElement();
				break;
			case 'Q':
				arrayOperations.printData();
				System.exit(0);
			default:
				System.out.println("Please choose again.");
			}
		}
	}
}
