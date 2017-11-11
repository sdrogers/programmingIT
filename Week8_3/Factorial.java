/**
 Calculate factorial of a given positive integer
 */
public class Factorial
{
	private int num;

	/**
	 Constructs a factorial object
	 @param aNum a positive integer
	 */
	public Factorial(int aNum)
	{
		num = aNum;
	}
	
	/**
	 Computes the factorial of num
	 @return factorial
	 */
	public double getFactorial()
	{
		if (num == 1) return 1;
		Factorial smallerFactorial = new Factorial(num - 1);
		double smallerValue = smallerFactorial.getFactorial();
		return smallerValue * num;
	}
}
