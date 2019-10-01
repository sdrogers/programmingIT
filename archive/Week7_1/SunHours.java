import java.util.Scanner;

/**
  Illustrates
  creating an integer array of known values
  printing each element of the array in normal order
  printing each element of the array in reverse order
*/

public class SunHours
{
	public static void main(String[] args)
	{
		//declare array of known values
		int [] sunHours = {4,1,8,3,6,9,5};

		// get length of array
		int arrayLen = sunHours.length;

		//print array in normal order
		System.out.print("Printing the old way:");
		for(int i=0;i<sunHours.length;i++)
			System.out.print(sunHours[i] + " ");
		System.out.println();
		
		
		System.out.print("Printing array in the normal order : ");
		for (int hours : sunHours)
			System.out.print(hours + "  ");
		System.out.println();
		
		//print array in reverse order
		System.out.print("\nPrinting array in reverse order : ");
		for (int index = arrayLen - 1; index >= 0; index--)
			System.out.print(sunHours[index] + "  ");
		System.out.println();
		
		
	}
}
