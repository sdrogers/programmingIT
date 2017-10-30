import java.util.*;

public class ShowArrayOperations2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner (System.in);
		ArrayOperations2 arrayOperations = new ArrayOperations2(in);
	        while (true)
		{	System.out.println("Enter A to add an element, "+
			"D to delete an element, and Q to quit");
			String choice = in.next();
			switch (choice.charAt(0))
                        {       case 'A':
				        arrayOperations.addElement();
				        break;
			        case 'D':
				        arrayOperations.deleteElement();
				        break;
			        case 'Q':
				{       arrayOperations.printData();
				        System.exit(0);
				}
			        default:
				        System.out.println("Please choose again.");
			}
		}
	}
}
