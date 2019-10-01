/**
 * Demonstrates use of the toString() method
 */

public class ToStringTest
{
	public static void main(String[] args)
	{
		BankAccount account = new BankAccount(31285);
		account.makeDeposit(13.79);
		System.out.println(account);
  }
}
