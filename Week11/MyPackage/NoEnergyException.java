package MyPackage;
/**
 * An Exception class for the situation when a Pet has insufficient energy to perform the proposed exercise 
 * @author simon
 *
 */
public class NoEnergyException extends Exception{
	private int myEnergy;
	public NoEnergyException(int e) {
		myEnergy = e;
	}
	/**
	 * Method to get the energy that the pet in question had
	 * @return returns the energy that the pet had 
	 */
	public int getEnergy() {
		return myEnergy;
	}

}
