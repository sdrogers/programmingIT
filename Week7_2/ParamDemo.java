/**
 * Contains methods whose purpose is to demonstrate 
 * some key principles of parameter passing
 */

public class ParamDemo
{
        public ParamDemo()
        {
        }

        // swaps values in two parameters
	// when called demonstrates that there is no change
	// to the actual parameters when the method exits

	public void swap(int a, int b)
	{
		int temp = a;
		a=b;
		b=temp;
	}
	
	// swaps the first two entries in the array parameter
	// when called demonstrates that the entries of an
	// actual parameter that is an array can be changed

	public void arraySwap(int[] twoNums)
	{
		int temp = twoNums[0];
		twoNums[0]=twoNums[1];
		twoNums[1]=temp;
	}
}
