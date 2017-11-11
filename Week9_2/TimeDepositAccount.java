/**
   An account that earns interest at a fixed rate until a maturity date.
*/
public class TimeDepositAccount extends SavingsAccount
{
   private int periodsToMaturity;
   private static double EARLY_WITHDRAWAL_PENALTY = 20;

   /**
      Constructs a bank account with a given interest rate and maturity.
      @param rate the interest rate
      @param maturity the number of months to maturity.
   */
   public TimeDepositAccount(int rate, int maturity)
   {
      super(rate);
      periodsToMaturity = maturity;
   }

   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest()
   {
      periodsToMaturity--;
      super.addInterest();
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      if (periodsToMaturity > 0)
         super.withdraw(EARLY_WITHDRAWAL_PENALTY + amount);
      else
         super.withdraw(amount);
   }
}
