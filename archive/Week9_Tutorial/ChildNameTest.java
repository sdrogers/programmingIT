
public class ChildNameTest {
	public static void main(String[] args) {
		int maxDistinctNames = 1000;
		// declare the number of distinct names read so far
		int numDistinctNames = 0;
		Name [] names = new Name [maxDistinctNames];
		
		// Assume we're reading names from the file
		// Also assume we have made a scanner for the file
		while(scanner.hasNextLine()) {
			String thisName = scanner.nextLine();
			if(numDistinctNames == 0) {
				Name newName = new Name(thisName);
				names[0] = newName;
				numDistinctNames ++;
			}else {
				boolean found = false;
				int i=0;
				while(!found & i<numDistinctNames)
				{
					if(thisName.equals(names[i].getName())) {
						found = true;
						names[i].incrementFrequency();
					}
					i++;
				}
				if(!found) {
					// add as a new one
					Name newName = new Name(thisName);
					names[numDistinctNames] = newName;
					numDistinctNames++;
					
					// The following is the same...
					names[numDistinctNames++] = new Name(thisName);
				}
			}
		}
	}
}
