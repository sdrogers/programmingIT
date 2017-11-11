/**
   An account that earns interest at a fixed rate.
*/
public class SavingsAccount extends BankAccount
{  
   private int interestRate;

   /**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate (in %)
   */
   public SavingsAccount(int rate) 
   {  
      interestRate = rate;
   }
 
   /**
      Withdraws money from the account, savings permitting.
      @param amount the amount to be withdrawn
   */
   public void withdraw (double amount)
   {
      int currentBalance = getBalance();
      int amountPence = (int) Math.round(amount*PENCE_PER_POUND);
      if (currentBalance >= amountPence)
	 super.withdraw(amount);
      else
         System.out.printf("Withdrawal of £%.2f was not permitted%n", amount);
   }
 
   /**
      Transfers money from the account, savings permitting.
      @param amount the amount to be withdrawn
   */
   public void transfer(double amount, BankAccount other)
   {  
      int oldBalance = getBalance();
      withdraw(amount);
      if (getBalance() != oldBalance) // withdrawal was permitted
         other.deposit(amount);
      else
         System.out.printf("Deposit of £%.2f was not permitted%n", amount);
   }

   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest() 
   {  
      double interest = getBalance() * interestRate / 100.0;
      deposit(interest/100.0); 
   }
}
