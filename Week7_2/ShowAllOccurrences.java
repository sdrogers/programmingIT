/**
 * Demonstrates passing arrays of integers to/from methods and
 * demonstrates printing all occurrences of a query in an array
 */
import java.io.*;
import java.util.*;

public class ShowAllOccurrences
{
	public static void main(String[] args)
	{
		final int NUM_ROLLS = 100;                //number of rolls of the die
                final int QUERY_NUM = 6;                  //number to search for
		int [] dieRolls = new int[NUM_ROLLS];     //array - to store all die rolls
		
		final String INFILE = "dieRolls.txt";     //input text file

		AllOccurrences allOccs = new AllOccurrences ();

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
					int side = in.nextInt();
					//store the die roll in the array
					dieRolls[roll] = side;
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
		// compute all occs of QUERY_NUM in dieRolls
		System.out.println(QUERY_NUM+" occurred at the following positions of "+INFILE+":");
		allOccs.computeAllOccs(dieRolls, QUERY_NUM);
		// print the matching indices
		allOccs.printAllOccs();
	}
}
