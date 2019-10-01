/**
 Contains methods for computing all occurrences and printing
 all occurrences of a query integer in a given array
 */
import java.io.*;
import java.util.*;

public class AllOccurrences
{
	private int numOccs; // store the actual number of matching indices
	private int [] occArray;

	public AllOccurrences()
	{
		numOccs = 0;
	}

	public void computeAllOccs(int [] inputArray, int queryNum)
	{
		// in the worst case all positions of inputArray match queryNum
		int arrayLen = inputArray.length;
		// declare array to store matching indices
		occArray = new int[arrayLen];
		// now compute matching indices
		for (int index=0; index<arrayLen; index++)
			if (inputArray[index]==queryNum)
			{
				// matching index - store it and increment
				// number of actual matching indices
				occArray[numOccs]=index;
				numOccs++;
			}
	}

	public void printAllOccs()
	{
		// output all matching indices
		for (int index=0; index<numOccs; index++)
			System.out.print(occArray[index]+" ");
	}
}
