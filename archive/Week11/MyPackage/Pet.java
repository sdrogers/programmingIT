package MyPackage;

/**
 * A class to represent pets
 * @author simon
 *
 */
public class Pet implements Comparable<Pet>{
	protected String name;
	protected int age;
	protected int energy;
	/**
	 * The default Pet constructor
	 * @param name the name of the pet
	 * @param age the age of the pet
	 */
	public Pet(String name,int age) {
		this.name = name;
		this.age = age;
		this.energy = 0;
	}
	/**
	 * Returns the age of the pet
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Returns the name of the pet
	 * @return pets name as a string
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The Pet says hello!
	 */
	public void sayHello() {
		System.out.println("Hello, I am " + name);
	}
	/**
	 * A method to feed your pet
	 * @param energy the energy input from the food
	 */
	public void feed(int energy) {
		this.energy += energy;
		System.out.println("Yum!");
	}
	/**
	 * Method to exercise 
	 * @param energy the energy to be consumed by this exercise
	 * @throws NoEnergyException throws the exception if the energy to be consumed is greater than the energy available to the pet
	 */
	public void exercise(int energy) throws NoEnergyException {
		if(energy < this.energy) {
			this.energy -= energy;
			System.out.println(name + " loves exercise!");
		}
		else {
			throw new NoEnergyException(this.energy);
		}
	}
	public int compareTo(Pet other) {
		if(this.age > other.getAge()) {
			return 1;
		}
		else if(this.age == other.getAge()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
