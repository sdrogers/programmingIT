
public class SavingsAccount extends BankAccount2{
	private double interestRate;
	public SavingsAccount(Person customer,double interestRate) {
		super(customer);
		this.interestRate = interestRate;
	}
	public String toString() {
		return super.toString() + " (savings)";
	}
	public void withdraw(double amount) throws InsufficientFundsException{
		/*
		 * getBalance is in the super class
		 * could use super.getBalance()
		 * but its unnecessary as there is only
		 * one getBalance method
		 */
		if(amount > getBalance()) { 
			throw new InsufficientFundsException();
		}else {
			super.withdraw(amount); // avoids code duplication
		}
	}
	public void addInterest() {
		double currentBalance = getBalance();
		double extra =  currentBalance * (interestRate/100.0);
		deposit(extra);
	}

}
