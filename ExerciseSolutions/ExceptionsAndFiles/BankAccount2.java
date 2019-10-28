
public class BankAccount2 {
	private Person customer;
	private int accountNumber;
	private double balance;
	private static int nextAccountNumber = 0;
	public BankAccount2(Person customer) {
		this.customer = customer;
		balance = 0.0;
		accountNumber = nextAccountNumber;
		nextAccountNumber ++;
	}
	public void deposit(double d) {
		balance += d;
	}
	public void withdraw(double d) {
		balance -=d;
	}
	public Person getCustomer() {
		return customer;
	}
	public void transfer(BankAccount2 other,double amount) {
		this.withdraw(amount);
		other.deposit(amount);
	}
	public String toString() {
		return "Account belonging to " + customer.getName() + ". Account number = " + accountNumber + ". Balance = £" + balance + ".";
	}
	public double getBalance() {
		return balance;
	}
}
