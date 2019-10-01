import FormatIO.*;

/**
   This class tests console input.
*/
public class InputTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();
      Console con = new Console();

      con.print("Enter price: ");
      double price = con.readDouble();
      register.recordPurchase(price);

      con.print("Enter dollars: ");
      int dollars = con.readInt();
      con.print("Enter quarters: ");
      int quarters = con.readInt();
      con.print("Enter dimes: ");
      int dimes = con.readInt();
      con.print("Enter nickels: ");
      int nickels = con.readInt();
      con.print("Enter pennies: ");
      int pennies = con.readInt();
      register.enterPayment(dollars, quarters, dimes, nickels, pennies);

      System.out.print("Your change is $");
      System.out.println(register.giveChange());
   }
}
