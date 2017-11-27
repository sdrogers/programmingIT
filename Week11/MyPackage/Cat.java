package MyPackage;
/**
 * A class for Cats extends the Pet class
 * @author simon
 *
 */
public class Cat extends Pet {

	public Cat(String name, int age) {
		super(name, age);
	}
	/**
	 * Override the Pet feed method to incorpoate some sleep!
	 */
	public void feed(int energy) {
		super.feed(energy);
		sleep();
	}
	/**
	 * Cats love sleeping
	 */
	private void sleep() {
		System.out.println(name + " has eaten and now needs to sleep");
	}
	
}
