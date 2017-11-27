
public class BankTester {
	public static void main(String[] args) {
		BankAccount1 ba = new BankAccount1(5,23);
		System.out.println(ba.pnds);
		
		BankAccount2 ba2 = new BankAccount2(6,34);
		System.out.println(ba2.getPnds());
	}
}
