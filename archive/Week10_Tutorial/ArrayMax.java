
public class ArrayMax {
	private int[] myarray; // The array to find the max of
	private int array_length; // The length of the array
	public ArrayMax(int[] arrayin) {
		myarray = arrayin;
		array_length = myarray.length;
	}
	public int getMax() {
		// Recursive method to find max
		// First the special case of a length 1 array
		if(array_length == 1) {
			return myarray[0];
		}else {
			// Otherwise, split it and return the max of the splits
			// put the first len1 entries into the first subarray
			int len1 = array_length/2;
			int[] sub1 = new int[len1];
			System.arraycopy(myarray, 0, sub1, 0, len1);
			// Put the remaining entries into the second subarray
			int[] sub2 = new int[array_length - len1];
			System.arraycopy(myarray, len1, sub2, 0, sub2.length);
			
			// Create two new ArrayMax objects
			ArrayMax aM1 = new ArrayMax(sub1);
			ArrayMax aM2 = new ArrayMax(sub2);
			
			// Get the maxes from those two
			int m1 = aM1.getMax();
			int m2 = aM2.getMax();
			
			// Return the bigger of the two
			if(m1 >= m2) {
				return m1;
			}else {
				return m2;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5,400,200,10,56,62,3,105,-1,-100000};
		ArrayMax am = new ArrayMax(a);
		System.out.println(am.getMax());
	}
	
}
