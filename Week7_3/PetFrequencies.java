/**
 * Demonstrates accumulating counts of the types of pets that people own
 */
import java.io.*;
import java.util.*;

public class PetFrequencies
{
	public static void main(String[] args)
	{
		final String INFILE = "PetTypes.txt";              // input text file
		final int MAX_PET_TYPES = 15;                      // maximum number of pet types
		String [] petTypes = new String[MAX_PET_TYPES];    // to store actual pet types
		int [] frequencies = new int[MAX_PET_TYPES];       // to store frequencies of pet types
		int numPetTypes = 0;                               // number of pet types actually read

		// initialise all types to null and all frequencies to 0
		for (int type=0; type<MAX_PET_TYPES; type++)
		{       
			petTypes[type] = null;
			frequencies[type] = 0;
		}

		FileReader fr = null;
		try
		{	try
		{	// open file
			fr = new FileReader(INFILE);
			// construct a scanner from fr
			Scanner in = new Scanner(fr);

			// while there are more pet types to read
			while (in.hasNextLine()) 
			{
				// read next pet type
				String petType = in.nextLine();
				// check to see if this type has already been seen
				int index=0;
				boolean found = false;
				while (index < numPetTypes && !found)
				{       // if we have already seen this pet type
					if (petType.equals(petTypes[index]))
					{       // increment the frequency for this type
						frequencies[index]++;
						found = true;
					}
					else
						index++;
				}
				if (!found)
				{       // this is a pet type we haven't seen already
					petTypes[numPetTypes]=petType;
					frequencies[numPetTypes]=1;
					numPetTypes++;
				}
			}

			// print header
			System.out.println("Pet type     Number of occurrences");
			// for each type of pet, output frequency count
			for (int type = 0; type < numPetTypes; type++)
				System.out.printf("%-22s%d%n", petTypes[type], frequencies[type]);

			System.out.println();

			// find the most popular pet type
			int maxIndexSoFar = 0;

			for (int index=1; index<numPetTypes; index++)
				if (frequencies[index] > frequencies[maxIndexSoFar])
					maxIndexSoFar = index;

			System.out.println("The most popular type of pet was a "+
					petTypes[maxIndexSoFar]);
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
		catch (ArrayIndexOutOfBoundsException abe)
		{
			System.out.print("Too many pet types: ");
			abe.printStackTrace(); // print out details of where exception occurred
			System.exit(1);        // exit abnormally
		}
	}
}
