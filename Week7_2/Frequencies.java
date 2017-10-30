/**
 * Demonstrates accumulating counts of the number of times a die roll comes 
 * up on a given side
 */
import java.io.*;
import java.util.*;

public class Frequencies
{
	public static void main(String[] args)
	{
		final int NUM_SIDES = 6;                  //number of sides on the die
		final int NUM_ROLLS = 100;                //number of rolls of the die
		int [] frequencies = new int[NUM_SIDES];  //array - entry for each side
		
		// initialise all frequencies to 0
		for (int side=0; side<NUM_SIDES; side++)
			frequencies[side]=0;
		
		final String INFILE = "dieRolls.txt";     //input text file
		FileReader fr = null;

		try
		{
			try
			{
				//READ FILE
				//open file
				fr = new FileReader(INFILE);
				// construct a scanner from fr
				Scanner in = new Scanner(fr);
				
				//for each roll of the die
				for (int roll = 0; roll < NUM_ROLLS; roll++)
				{
					//read next integer
					int dieRoll = in.nextInt();
					//increment entry of frequency according to which number was rolled
					frequencies[dieRoll-1]++;
				}
			}
			finally
			{
				//close file, assuming it was successfully opened
				if (fr!=null) fr.close();
			}
		}
		//EXCEPTIONS
		catch (IOException ioe)
		{
			System.out.println("File I/O error: ");
			ioe.printStackTrace(); // print out details of where exception occurred
			System.exit(1);        // exit abnormally
		}
		catch (InputMismatchException ime)
		{
			System.out.print("Input mismatch error: ");
			ime.printStackTrace(); // print out details of where exception occurred
			System.exit(1);        // exit abnormally
		}

		//print header
		System.out.println("Side    Number of occurrences");

		//for each face of the die, output frequency count
		for (int side = 0; side < NUM_SIDES; side++)
			System.out.printf(" %d%15c%d%n", side+1, ' ', frequencies[side]);
		System.out.println();
		
		// find the number of times the frequency exceeds a given threshold
		final int THRESHOLD = 17;
		int matches = 0;
		
		for (int freq : frequencies)
			if (freq >= THRESHOLD)
				matches++;
		
		System.out.println(matches+" of the die sides came up an "+
		                   "above-average number of times.");
				
		// find the side that came up the largest number of times
		int maxIndexSoFar = 0;

		for (int index=1; index<NUM_SIDES; index++)
			if (frequencies[index] >
			    frequencies[maxIndexSoFar])
				maxIndexSoFar = index;

		System.out.println("Side "+(maxIndexSoFar+1)+" came up the "+
		                   "largest number of times.");

		// find the side that came up the smallest number of times
		int minIndexSoFar = 0;

		for (int index=1; index<NUM_SIDES; index++)
			if (frequencies[index] <
			    frequencies[minIndexSoFar])
				minIndexSoFar = index;

		System.out.println("Side "+(minIndexSoFar+1)+" came up the "+
		                   "smallest number of times.");
	}
}
