/**
 This bank contains a collection of bank accounts
 */
import java.util.*;

public class BankManager
{	
	private final int PENCE_PER_POUND = 100;
	private final int MAX_BANK_ACCOUNTS = 3;
	private BankAccount [] bankAccounts;
	private int numAccounts;
	
	/**
	 Constructs a bank with no bank accounts
	 */
	public BankManager()
	{
		bankAccounts = new BankAccount [MAX_BANK_ACCOUNTS];
		numAccounts = 0;
	}
	
	/**
	 Adds an account to this bank.
	 @param account the account to add
	 */
	public BankAccount openAccount(int accountNumber)
	{
		BankAccount account = null;
		if (numAccounts==MAX_BANK_ACCOUNTS)
			System.out.println("Bank full.  No new accounts can be opened.");
		else if (findAccount(accountNumber)!=null)
			System.out.println("Account number "+accountNumber+" already exists!");
		else
		{	account = new BankAccount(accountNumber);
			bankAccounts[numAccounts] = account;
			numAccounts++;
		}
		return account;
	}
	
	/**
	 Deletes an account from this bank
	 @param account the account to close
	 */
	public void closeAccount(int accountNumber)
	{
		boolean found = false;
		int index = 0;
		while (index<numAccounts && !found)
		{
			BankAccount account = bankAccounts[index];
			if (account.getAccountNumber()==accountNumber)
			{
				bankAccounts[index] = bankAccounts[numAccounts-1];
				numAccounts--;
				found = true;
			}
			else
				index++;
		}
		if (!found)
		{
			System.out.println("No account with number "+accountNumber+" exists!");
		}
	}
	
        /**
         Display the balance of all accounts in this bank
	*/
        public void displayAllAccounts()
        {     
	        System.out.println("Displaying all accounts in the bank");
                for (int i=0; i< numAccounts; i++)
		{
                        BankAccount account = bankAccounts[i];
                        account.displayBalance();
		}
	}

	/**
	 Display the total balance of all accounts in this bank
	 */
	public void displayTotalBalance()
	{
		int total = 0;
		for (int i=0; i< numAccounts; i++)
		{
			BankAccount account = bankAccounts[i];
			total += account.getBalance();
		}
		System.out.printf("The total balance is: £%d.%02d.%n", 
				           total/PENCE_PER_POUND, total%PENCE_PER_POUND);
	}
	
	/**
	 Finds a bank account with a given number
	 @param accountNumber the number to find
	 @return the account with the given number, or null if there
	 is no such account
	 */
	public BankAccount findAccount(int accountNumber)
	{
		for (int i=0; i <numAccounts; i++)
		{
			BankAccount account = bankAccounts[i];
			if (account.getAccountNumber() == accountNumber) // Found a match
				return account;
		} 
		return null; // No match in the entire array list
	}
	
	/**
	 Gets the bank account with the largest balance.
	 @return the account with the largest balance, or null if the
	 bank has no accounts
	 */
	public BankAccount getMaximum()
	{
		if (numAccounts==0) return null;
		BankAccount largestYet = bankAccounts[0]; 
		for (int i = 1; i < numAccounts; i++) 
		{
			BankAccount account = bankAccounts[i];
			if (account.getBalance() > largestYet.getBalance())
			{
				largestYet = account;
			}
		}
		return largestYet;
	}

        /**
         Sorts accounts in non-decreasing order of balance
	*/
        public void sortAccounts()
        {
	    Arrays.sort(bankAccounts, 0, numAccounts);
	}
}
