/**
 Class to implement simple operations on a bank account
 */
public class BankAccount implements Comparable<BankAccount>
{   
	private final int PENCE_PER_POUND =  100;
	private int accountNumber;
	private int pounds;
	private int pence;

	/**
	 Constructor for the class
	 @param n the account number
	 */
	public BankAccount(int n)
	{
		accountNumber = n;
		pounds = 0;
		pence = 0;
	}

        public int compareTo(BankAccount other)
        {
	        int thisBalance = this.getBalance();
                int otherBalance = other.getBalance();
		if (thisBalance < otherBalance)
		        return -1;
		else if (thisBalance == otherBalance)
		        return 0;
		else
		        return 1;
	}

	/**
	 Deposit a sum of money in this account
	 @param amount the amount of money to deposit
	 */
	public void makeDeposit (double amount)
	{
		int currentBalance = pounds*PENCE_PER_POUND + pence;
		currentBalance += (int) Math.round(amount*PENCE_PER_POUND);
		pounds = currentBalance / PENCE_PER_POUND;
		pence = currentBalance % PENCE_PER_POUND;
	}

	/**
	 Withdraw a sum of money from this account
	 @param amount the amount of money to withdraw
	 */
	public void makeWithdrawal (double amount)
	{
		int currentBalance = pounds*PENCE_PER_POUND + pence;
		currentBalance -= (int) Math.round(amount*PENCE_PER_POUND);
		pounds = currentBalance / PENCE_PER_POUND;
		pence = currentBalance % PENCE_PER_POUND;
	}

	/**
	 Get the balance of this account
	 @return the balance in pence
	 */
	public int getBalance()
	{
		return pounds*PENCE_PER_POUND + pence;
	}

	/**
	 Get the account number of this account
	 @return the account number
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 Display the account number and current balance of this account.
	 */
	public void displayBalance()
	{
		System.out.printf("The current balance of account %d is £%d.%02d.%n",
			              accountNumber, pounds, pence);
	}
}
