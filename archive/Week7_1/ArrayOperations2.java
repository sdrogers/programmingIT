import java.util.*;

public class ArrayOperations2
{
	double [] data;
	Scanner in;
	int arrayLen = 0;

	public ArrayOperations2(Scanner console) {
		in = console; 
		data = new double [arrayLen];
	}

	public void addElement()
	{
		System.out.println("Enter the value to be stored");
		double d = in.nextDouble();
		double [] newData = new double[arrayLen+1];
		System.arraycopy(data, 0, newData, 0, arrayLen);
		data = newData;
		data[arrayLen] = d;
		arrayLen++;
		System.out.println("Element "+d+" added at index "+arrayLen);
	}

	public void deleteElement() {
		System.out.println("Enter the index to be deleted");
		int index = in.nextInt();
		if (index <0 || index>=arrayLen)
			System.out.println("The index is out of bounds.");
		else 
		{
			arrayLen--;
			data[index] = data[arrayLen];
			double [] newData = new double[arrayLen];
			System.arraycopy(data, 0, newData, 0, arrayLen);
			data = newData;
			System.out.println("Element "+data[index]+" removed from index "+index);
		}
	}

	public void printData() {
		System.out.println("The contents of the array are:");
		for (int i=0; i< arrayLen; i++) {
			double d = data[i];
			System.out.print(d+" ");
		}
		System.out.println();
	}
}
