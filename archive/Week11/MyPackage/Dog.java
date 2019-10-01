package MyPackage;
/**
 * A class for dogs. Extends the pet class
 * @author simon
 *
 */
public class Dog extends Pet {

	/**
	 * We have to define a constructor as there is no non-parameter constructor in the super class
	 * @param name the name of the dog
	 * @param age the age of the dog
	 */
	public Dog(String name, int age) {
		super(name, age);
	}
	/**
	 * Here we override the sayHello() method of Pet
	 */
	public void sayHello() {
		System.out.println("WOOF!!");
	}
	/**
	 * Dogs love chasing cats
	 * @param c the cat object that this Dog is chasing
	 */
	public void chase(Cat c) {
		System.out.println(name + " is chasing a cat called " + c.getName());
	}

}
