import java.math.*;
import FormatIO.*;

/**
   This class tests console input.
*/
public class InputTester3
{
   public static void main(String[] args)
   {
      Console con = new Console();
      CashRegister3 register = new CashRegister3();

      con.print("Enter price: ");
      String price = con.readLine();
      register.recordPurchase(new BigDecimal(price));

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

      con.print("Your change is $");
      con.println(register.giveChange().toString());
   }
}
