import java.util.*;

public class ArrayOperations
{
	double [] data;
	Scanner in;
	int actualLen = 0;

	public ArrayOperations(Scanner console, int arrayLen) {
		in = console; 
		data = new double [arrayLen];
	}

	public void addElement() {
		if (actualLen == data.length)
			System.out.println("The array is already full.");
		else 
		{
			System.out.println("Enter the value to be stored");
			double d = in.nextDouble();
			data[actualLen] = d;
			System.out.println("Element "+d+" added at index "+actualLen);
			actualLen++;
		}
	}

	public void deleteElement() {
		System.out.println("Enter the index to be deleted");
		int index = in.nextInt();
		if (index <0 || index>=actualLen)
			System.out.println("The index is out of bounds.");
		else 
		{
			System.out.println("Element "+data[index]+" removed from index "+index);
			actualLen--;
			data[index] = data[actualLen];
		}
	}

	public void printData() {
		System.out.println("The contents of the array are:");
		for (int i=0; i< actualLen; i++) 
		{
			double d = data[i];
			System.out.print(d+"  ");
		}
		System.out.println();
	}
}
