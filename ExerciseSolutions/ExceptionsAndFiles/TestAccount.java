
public class TestAccount {

	public static void main(String[] args) {
		Person p = new Person("Bill",56,"blue");
		SavingsAccount s = new SavingsAccount(p,5);
		s.deposit(100.0);
		s.withdraw(90.0);
		s.withdraw(20.0); // exception thrown here - can catch it if you want!
	}

}
