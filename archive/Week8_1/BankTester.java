/**
   This program tests the BankAccount class
 */
public class BankTester
{
	public static void main(String[] args)
	{
		BankManager bank = new BankManager();

		// open two new accounts	   
		BankAccount account0 = bank.openAccount(30125);
		BankAccount account1 = bank.openAccount(10569);
		// try to open a new account with an existing account number
		BankAccount account = bank.openAccount(10569);
		//open a third new account
		BankAccount account2 = bank.openAccount(30527);

		// try to open a fourth account - error (too many accounts)
		BankAccount account3 = bank.openAccount(90524);

		// make some transactions on the first account
		account0.makeDeposit(17.35);
		account0.makeDeposit(142.97);
		account0.makeWithdrawal(35.41);
		account0.makeDeposit(47.59);

		// print the balance of first account
		account0.displayBalance();

		// make some further transactions
		account1.makeDeposit(273.65);
		account2.makeDeposit(356.23);

		// try to close account 30524 - error (no such account)   
		bank.closeAccount(30524);
		// close account 30125
		bank.closeAccount(30125);

		// now open another account
		BankAccount account4 = bank.openAccount(90524);
		account4.makeDeposit(194.82);
		
		account4.displayBalance();

		// display total balance of all accounts
		bank.displayTotalBalance();

		// display account with the largest balance
		BankAccount maxAccount = bank.getMaximum();
		System.out.printf("The account with the largest balance is %d.%n",
				          maxAccount.getAccountNumber());
		maxAccount.displayBalance();

		bank.displayAllAccounts();
		bank.sortAccounts();
	        bank.displayAllAccounts();
	}
}
