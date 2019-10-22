public class SavingsAccount extends BankAccountPerson {
	private double interestRate;
	public SavingsAccount(Person accountHolder,double interestRate) {
		super(accountHolder); // Super call has to be first in constructor
		this.interestRate = interestRate;
	}
	public void withdraw(int amount) {
		if(amount <= getBalance()) {
			super.withdraw(amount); // Neatest to use this
		}else {
			System.out.println("Withdrawal unsuccessful");
		}
	}
	public void addInterest() {
		// Compute the amount of interest
		double interest = getBalance*(interestRate/100.0);
		int interestInt = (int)interest; // because balance is an int - this rounds down..banks are mean
		// deposit it into the account
		deposit(interestInt);
	}
}