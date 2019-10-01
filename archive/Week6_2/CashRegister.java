/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;

   private static final double QUARTER_VALUE = 0.25;
   private static final double DIME_VALUE = 0.1;
   private static final double NICKEL_VALUE = 0.05;
   private static final double PENNY_VALUE = 0.01;

   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0.0;
      payment = 0.0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase += amount;
   }
   
   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void enterPayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0.0;
      payment = 0.0;
      return change;
   }
}
