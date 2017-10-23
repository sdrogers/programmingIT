import java.math.*;

/**
 A cash register totals up sales and computes change due.
 */
public class CashRegister3
{
	public static final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");
	public static final BigDecimal DIME_VALUE = new BigDecimal("0.10");
	public static final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");
	public static final BigDecimal PENNY_VALUE = new BigDecimal("0.01");
	
	private BigDecimal purchase;
	private BigDecimal payment;
	
	/**
	 Constructs a cash register with no money in it.
	 */
	public CashRegister3()
	{
		purchase = new BigDecimal("0.00");
		payment = new BigDecimal("0.00");
	}
	
	/**
	 Records the purchase price of an item.
	 @param amount the price of the purchased item
	 */
	public void recordPurchase(BigDecimal amount)
	{
		purchase = purchase.add(amount);
	}
	
	/**
	 Enters the payment received from the customer.
	 @param dollars the number of dollars in the payment
	 @param quarters the number of quarters in the payment
	 @param dimes the number of dimes in the payment
	 @param nickels the number of nickels in the payment
	 @param pennies the number of pennies in the payment
	 */
	public void enterPayment(int dollars, int quarters, 
			int dimes, int nickels, int pennies)
	{
		payment = payment.add(new BigDecimal(dollars));
		payment = payment.add(QUARTER_VALUE.multiply(new BigDecimal(quarters)));
		payment = payment.add(DIME_VALUE.multiply(new BigDecimal(dimes)));
		payment = payment.add(NICKEL_VALUE.multiply(new BigDecimal(nickels)));
		payment = payment.add(PENNY_VALUE.multiply(new BigDecimal(pennies))); 
	}
	
	/**
	 Computes the change due and resets the machine for the next customer.
	 @return the change due to the customer
	 */
	public BigDecimal giveChange()
	{
		BigDecimal change = payment.subtract(purchase);
		purchase = new BigDecimal("0.00");
		payment = new BigDecimal("0.00");
		return change;
	}
}
