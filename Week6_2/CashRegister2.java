<<<<<<< HEAD
/**
A cash register totals up sales and computes change due.
*/

import FormatIO.*;

public class CashRegister2
{
   private static final int PENNIES_PER_DOLLAR = 100;
   private static final int PENNIES_PER_QUARTER = 25;
   private static final int PENNIES_PER_DIME = 10;
   private static final int PENNIES_PER_NICKEL = 5;

   private int purchase;
   private int change;

   /**
   Constructs a cash register with no money in it.
   */
   public CashRegister2()
   {
      purchase = 0;
      change = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase += (int) Math.round(amount * PENNIES_PER_DOLLAR);
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
      int payment = dollars * PENNIES_PER_DOLLAR 
         + quarters * PENNIES_PER_QUARTER + dimes * PENNIES_PER_DIME
         + nickels * PENNIES_PER_NICKEL + pennies;
      change = payment - purchase;            
   }
   
   /**
   Prints out the change due and resets the machine for the next customer.
*/
   public void giveChange(Console con)
   {
      con.println(" Dollars: "+giveDollars());
      con.println("Quarters: "+giveQuarters());
      con.println("   Dimes: "+giveDimes());
      con.println(" Nickels: "+giveNickels());
      con.println(" Pennies: "+givePennies());
      purchase = 0;
      change = 0;
   }
   
   /**
      Computes the number of dollars due to the customer.
      @return the number of dollars in the change due
   */
   public int giveDollars()
   {
      int dollars = change / PENNIES_PER_DOLLAR; 
      change -= dollars * PENNIES_PER_DOLLAR;
      return dollars;
   }

   /**
      Computes the number of quarters due to the customer.
      @return the number of quarters in the change due
   */
   public int giveQuarters()
   {
      int quarters = change / PENNIES_PER_QUARTER; 
      change -= quarters * PENNIES_PER_QUARTER;
      return quarters;
   }

   /**
      Computes the number of dimes due to the customer.
      @return the number of dimes in the change due
   */
   public int giveDimes()
   {
      int dimes = change / PENNIES_PER_DIME; 
      change -= dimes * PENNIES_PER_DIME;
      return dimes;
   }

   /**
      Computes the number of nickels due to the customer.
      @return the number of nickels in the change due
   */
   public int giveNickels()
   {
      int nickels = change / PENNIES_PER_NICKEL; 
      change -= nickels * PENNIES_PER_NICKEL;
      return nickels;
   }

   /**
      Computes the number of pennies due to the customer.
      @return the number of pennies in the change due
   */
   public int givePennies()
   {
      int pennies = change; 
      change = 0;
      return pennies;
   }
}
=======
/**
A cash register totals up sales and computes change due.
*/

import FormatIO.*;

public class CashRegister2
{
   private static final int PENNIES_PER_DOLLAR = 100;
   private static final int PENNIES_PER_QUARTER = 25;
   private static final int PENNIES_PER_DIME = 10;
   private static final int PENNIES_PER_NICKEL = 5;

   private int purchase;
   private int change;

   /**
   Constructs a cash register with no money in it.
   */
   public CashRegister2()
   {
      purchase = 0;
      change = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase += (int) Math.round(amount * PENNIES_PER_DOLLAR);
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
      int payment = dollars * PENNIES_PER_DOLLAR 
         + quarters * PENNIES_PER_QUARTER + dimes * PENNIES_PER_DIME
         + nickels * PENNIES_PER_NICKEL + pennies;
      change = payment - purchase; 
   }
   
   /**
   Prints out the change due and resets the machine for the next customer.
*/
   public void giveChange(Console con)
   {
      con.println(" Dollars: "+giveDollars());
      con.println("Quarters: "+giveQuarters());
      con.println("   Dimes: "+giveDimes());
      con.println(" Nickels: "+giveNickels());
      con.println(" Pennies: "+givePennies());
      purchase = 0;
      change = 0;
   }
   
   /**
      Computes the number of dollars due to the customer.
      @return the number of dollars in the change due
   */
   public int giveDollars()
   {
      int dollars = change / PENNIES_PER_DOLLAR; 
      change -= dollars * PENNIES_PER_DOLLAR;
      return dollars;
   }

   /**
      Computes the number of quarters due to the customer.
      @return the number of quarters in the change due
   */
   public int giveQuarters()
   {
      int quarters = change / PENNIES_PER_QUARTER; 
      change -= quarters * PENNIES_PER_QUARTER;
      return quarters;
   }

   /**
      Computes the number of dimes due to the customer.
      @return the number of dimes in the change due
   */
   public int giveDimes()
   {
      int dimes = change / PENNIES_PER_DIME; 
      change -= dimes * PENNIES_PER_DIME;
      return dimes;
   }

   /**
      Computes the number of nickels due to the customer.
      @return the number of nickels in the change due
   */
   public int giveNickels()
   {
      int nickels = change / PENNIES_PER_NICKEL; 
      change -= nickels * PENNIES_PER_NICKEL;
      return nickels;
   }

   /**
      Computes the number of pennies due to the customer.
      @return the number of pennies in the change due
   */
   public int givePennies()
   {
      int pennies = change; 
      change = 0;
      return pennies;
   }
}
>>>>>>> pr/4
