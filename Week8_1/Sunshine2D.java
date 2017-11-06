/** Demonstrates 2D arrays
 * Assume that text file contains 28 values
 * ALGORITHM
 * read lines containing hours of sunshine for each day of a week
 * print report to file for each item in list
 * listing for each day, the hours of sunshine per week
 */
import java.io.*;
import java.util.*;

public class Sunshine2D
{
	public static void main(String[] args)
	{
		//declare list of sunshine hours
		WeeksOfSun sunshine = new WeeksOfSun();
		
		final int NUM_DAYS = 28;                       //number of days in 4 weeks
		
		final String INFILE = "sunstatsIn2D.txt";      //input text file
		final String OUTFILE = "sunstatsOut2D.txt";    //output text file
		
		FileReader fr = null;
		PrintWriter pw = null;
		try
		{
			try 
			{	//READ FILE
				//open input file
				fr = new FileReader(INFILE);
				Scanner in = new Scanner(fr);
				//for each week
				for (int dayIndex = 0; dayIndex < NUM_DAYS; dayIndex++)
				{
					//read next integer
					int hours = in.nextInt();
					//store each item in array
					sunshine.addEntry(hours);
				}
				
				//PRINT FILE
				//open output file
				pw = new PrintWriter(OUTFILE);
				//obtain report and print it
				String report = sunshine.reportSunHours();
				pw.print(report);
			}
			finally
			{	// close files assuming they were successfully opened
				if (fr!=null) fr.close();
			}	if (pw!=null) pw.close();
		}
		//exception handling
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}
		catch (InputMismatchException ime)
		{
		        ime.printStackTrace();
			System.exit(1);
		}
	}
}
