public class BankAccountPerson {
	private Person accountHolder;
	private int accountNumber;
	private static int nextAccountNumber = 0;
	private int balance;
	public BankAccountPerson(Person accountHolder) {
		balance = 0;
		this.accountHolder = accountHolder;
		accountNumber = nextAccountNumber++;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance -= amount;
	}
	public void deposit(int amount) {
		balance += amount;
	}
	public String toString() {
		return accountHolder.getName() + " has a balance of " + balance;
	}
	public void transferFunds(int amount,BankAccountPerson other) {
		// transfers amount from this account to other
		this.withdraw(amount); // the this here is not necessary, but aids clarity
		other.deposit(amount);
	}
}