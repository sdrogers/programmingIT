public class BankAccount {
	private String accountHolder;
	private int accountNumber;
	private static int nextAccountNumber = 0;
	private int balance;
	public BankAccount(String name) {
		balance = 0;
		accountHolder = name;
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
		return accountHolder + " has a balance of " + balance;
	}
}