/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   private int balance;       // balance in pence
   private final int PENCE_PER_POUND = 100;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {   
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(int initialBalance)
   {   
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(int amount)
   {  
      balance += amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(int amount)
   {   
      balance -= amount;
   }

   /**
      Adds interest to the bank balance.

   */
   public void addInterest(int rate)
   {  
      int interest = (int) Math.round(balance * rate / 100.0);
      deposit(interest);
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public int getBalance()
   {   
      return balance;
   }

   /**
      Displays the current balance of the bank account.
   */
   public String showBalance()
   {   
      return String.format("Balance = £%d.%02d%n", balance / PENCE_PER_POUND, balance % PENCE_PER_POUND);
   }
}
