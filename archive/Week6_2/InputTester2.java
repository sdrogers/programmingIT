import FormatIO.*;

/**
   This class tests console input.
*/
public class InputTester2
{
   public static void main(String[] args)
   {
      Console con = new Console();

      CashRegister2 register = new CashRegister2();

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

      con.println("Your change is as follows.");
      register.giveChange(con);
   }
}
