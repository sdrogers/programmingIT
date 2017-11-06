/**
 * Demonstrates parameter passing
 */

public class ParamDemoMain
{
	public static void main(String[] args)
	{
		ParamDemo paramDemo = new ParamDemo();
		int first = 5;
		int second = 10;
		//this gives the numbers in order 5,10
		System.out.println("First "+first+" Second "+second);
		paramDemo.swap(first,second);
		//this output might surprise you
		System.out.println("First "+first+" Second "+second);
		System.out.println();

		int[] littleArray = {5,10};
		//this outputs the little array
		for (int i=0;i<littleArray.length;i++)
		{
			System.out.print("Entry "+i +": "+littleArray[i]+"  ");
		}
		System.out.println();
		paramDemo.arraySwap(littleArray);
		//think about what you would expect here
		for (int i=0;i<littleArray.length;i++)
		{
			System.out.print("Entry "+i +": "+littleArray[i]+"  ");
		}
	}		
}
