/**
   This program tests the BankAccount3 class
 */
public class BankTester3
{
	public static void main(String[] args)
	{
		BankManager bank = new BankManager();

		// open two new accounts	   
		BankAccount3 account0 = bank.openAccount(30125);
		BankAccount3 account1 = bank.openAccount(10569);
		// try to open a new account with an existing account number
		BankAccount3 account = bank.openAccount(10569);
		//open a third new account
		BankAccount3 account2 = bank.openAccount(30527);

		// try to open a fourth account - error (too many accounts)
		BankAccount3 account3 = bank.openAccount(90524);

		// make some transactions on the first account
		account0.makeDeposit(17.35);
		account0.makeDeposit(142.97);
		account0.makeWithdrawal(35.41);
		account0.makeDeposit(47.59);

		// print the balance of first account
		account0.displayBalance();

		// make some further transactions
		account1.makeDeposit(273.65);
		account2.makeDeposit(56.23);

		// try to close account 30524 - error (no such account)   
		bank.closeAccount(30524);
		// close account 30125
		bank.closeAccount(30125);

		// now open another account
		BankAccount3 account4 = bank.openAccount(90524);
		account4.makeDeposit(194.82);

		account4.displayBalance();

		// display total balance of all accounts
		bank.displayTotalBalance();

		// display account with the largest balance
		BankAccount3 maxAccount = bank.getMaximum();
		System.out.printf("The account with the largest balance is %d.%n",
				maxAccount.getAccountNumber());
		maxAccount.displayBalance();

		// display balance of account 30527
		account = bank.findAccount(30527);
		account.displayBalance();
	}
}
