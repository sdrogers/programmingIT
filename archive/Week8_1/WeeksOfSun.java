/*
 Illustrates 2D arrays
 */
import java.io.*;

public class WeeksOfSun
{
	private final int NUM_DAYS = 7;
	private final int NUM_WEEKS = 4;
	private int [][] sunHours;              //array of weeks of days
	private int dayNumber;			//number of days in current week that are filled in
	private int weekNumber;			//number of weeks that are filled in
	
	// creates array of given dimensions
	// sets number of days and weeks in list to 0
	public WeeksOfSun()
	{
		sunHours = new int [NUM_WEEKS][NUM_DAYS];
		dayNumber = 0;
		weekNumber= 0;
	}
	
	//adds an entry to the list & increases day and week number of entries
	//parameter : int number : the item to be added
	public void addEntry(int number)
	{
		sunHours[weekNumber][dayNumber] = number;  //store number in array
		dayNumber++;         //inc day count
		if (dayNumber%7==0)  //if end of week
		{
			dayNumber = 0;			   //reset day count
			weekNumber++;			   //inc week count
		}
	}
	
	/*
	Returns String report
	showing for each day of week, hours for each week
	*/
	public String reportSunHours()
	{	//create header
		String report = "Day    ";
		for (int weekCount = 1; weekCount <= NUM_WEEKS; weekCount++)
		{
			String paddedWk = String.format("Week %-5d", weekCount);
			report += paddedWk;
		}
		report += '\n';
		//for each day of week (i.e. line of text)
		
		for (int dayIndex = 0; dayIndex < NUM_DAYS; dayIndex++)
		{
			//start line with day of week and the weekday text
			report += String.format("%2d",dayIndex+1);
			//for each week, add hours
			for (int weekIndex = 0; weekIndex < NUM_WEEKS; weekIndex ++)
			{
				int hours = sunHours[weekIndex][dayIndex];
				String paddedHours = String.format("%9d ", hours);
				report += paddedHours;
			}
			report += '\n';  //newline at end of each line
		}
		return report;
	}
}
