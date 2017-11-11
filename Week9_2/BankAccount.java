/**
 Class to implement simple operations on a bank account
 */
public class BankAccount
{   
        public static final int PENCE_PER_POUND = 100;
	private int pounds;
	private int pence;
	
	public BankAccount()
	{
		pounds = 0;
		pence = 0;
	}
	
        public BankAccount(double initialDeposit)
        {
                int initialDepositInt = (int) Math.round(initialDeposit * PENCE_PER_POUND);
	        pounds = initialDepositInt / PENCE_PER_POUND;
	        pence = initialDepositInt % PENCE_PER_POUND;
	}

	public void deposit (double amount)
	{
	        int currentBalance = (pounds*PENCE_PER_POUND) + pence;
		currentBalance += (int) Math.round(amount*PENCE_PER_POUND);
		pounds = currentBalance / PENCE_PER_POUND;
		pence = currentBalance % PENCE_PER_POUND;
	}
	
	public void withdraw (double amount)
	{
		int currentBalance = (pounds*PENCE_PER_POUND) + pence;
		currentBalance -= (int) Math.round(amount*PENCE_PER_POUND);
		pounds = currentBalance / PENCE_PER_POUND;
		pence = currentBalance % PENCE_PER_POUND;
	}

        public void transfer(double amount, BankAccount other)
        {  
                withdraw(amount);
                other.deposit(amount);
	}

        public int getBalance()
        {
	        return pounds*PENCE_PER_POUND + pence;
	}

        public String showBalance()
        {
	        return String.format("£%d.%02d%n",pounds,pence);
	}
}
