public class BankTest {
	public static void main(String[] args) {
		BankAccount a = new BankAccount("Simon");
		BankAccount b = new BankAccount("Fred");
		System.out.println(a.getAccountNumber());
		System.out.println(b.getAccountNumber());

		a.deposit(100);
		a.withdraw(20);
		System.out.println(a);
		Person alice = new Person("Alice",5);
		Person bella = new Person("Bella",27);
		BankAccountPerson c = new BankAccountPerson(alice);
		BankAccountPerson d = new BankAccountPerson(bella);
		System.out.println(c.getAccountNumber());
		System.out.println(d.getAccountNumber());

		c.deposit(100);
		c.withdraw(20);

		System.out.println(c);

		c.transferFunds(10,d);
		System.out.println(c);
		System.out.println(d);
	}
}