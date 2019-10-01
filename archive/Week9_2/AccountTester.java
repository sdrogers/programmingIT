/**
   This program tests the BankAccount class and its subclasses. 
*/
public class AccountTester
{  
   public static void main(String[] args)
   {  
	  BankAccount simonsaccount = new BankAccount(10000000); 
      SavingsAccount mumsSavingsAccount = new SavingsAccount(5);
      
      CurrentAccount jimsCurrentAccount = new CurrentAccount(100);
         
      mumsSavingsAccount.deposit(10000);
      
      mumsSavingsAccount.transfer(2000, jimsCurrentAccount);     
      jimsCurrentAccount.withdraw(1500);
      jimsCurrentAccount.withdraw(80);      

      mumsSavingsAccount.transfer(1000, jimsCurrentAccount);
      jimsCurrentAccount.withdraw(400);      

      mumsSavingsAccount.transfer(9000, jimsCurrentAccount);

      // Simulate end of month
      mumsSavingsAccount.addInterest();
      jimsCurrentAccount.deductFees();
      
      System.out.print("Mum's savings account balance = "
            + mumsSavingsAccount.showBalance());

      System.out.print("Jim's current account balance = "
            + jimsCurrentAccount.showBalance());
   }
}
