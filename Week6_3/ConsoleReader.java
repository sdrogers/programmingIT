/**
 Class to illustrate reading from the console using Scanner
*/

import java.util.*;

public class ConsoleReader
{
   public static void main(String[] args)
   {
      // read from the console using a Scanner object
      Scanner console = new Scanner(System.in);

      // get item description (a string)
      System.out.print("Enter description: ");
      String description = console.nextLine();

      // get item code (mixture of letters and digits)
      System.out.print("Enter item code: ");
      String itemCode = console.next();

      // get price information (a double)
      System.out.print("Enter price: ");
      double price = console.nextDouble();

      // get quantity information (an integer)
      System.out.print("Enter quantity: ");
      int quantity = console.nextInt();

      // confirm order back to user
      System.out.println("You ordered "+quantity+
        " item/s @"+price+" of type "+description+" with code "+itemCode);
   }
}
