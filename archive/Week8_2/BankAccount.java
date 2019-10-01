/**
 Class to implement simple operations on a bank account
 */
public class BankAccount
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
	
    /*  public String toString()
	{
		return String.format("The balance of account %d is £%d.%02d.%n",
				accountNumber, pounds, pence);
	}
    */
}
