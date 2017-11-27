import MyPackage.Pet;
import MyPackage.Dog;
import MyPackage.LazyDog;
import MyPackage.Cat;
import MyPackage.NoEnergyException;

public class PetTester {
	public static void main(String[] args) {
		Pet p = new Pet("Rex",6);
		p.sayHello();
		
		p.feed(50);
		try {
			p.exercise(30);
			p.exercise(30);
		}
		catch(NoEnergyException e) {
			System.out.println("Sorry, " + p.getName() + " can't exercise, only has " + e.getEnergy() + " energy!");
		}
		
		Dog d = new Dog("Bob",12);
		d.sayHello();
		
		Pet p2 = new Dog("Bonzo",10);
		p2.sayHello();
		
		Cat c = new Cat("Flo",2);
		c.sayHello();
		c.feed(100);
		
		d.chase(c);
//		p2.chase(c); Doesn't work!
		
		Pet p3 = new Cat("Lou",3);
//		d.chase(p3); Doesn't work!
//		but you can cast
		d.chase((Cat)p3);
		
		
		LazyDog l = new LazyDog("Clive",25);
		l.exercise(10);
		
//		Look at this crazy polymorphism! We can store a LazyDog object with a reference type anywhere higher up the hierarchy!
		Dog d2 = l;
		Pet p4 = l;
		Object o = l;
		
		// And calling the exercise method from the LazyDog ref is like this
		l.exercise(10);
		
		// But if from the Dog or Pet, we need to handle the exception
		// even though it is the method version in lazy dog that is used! 
		try {
			d2.exercise(10);
		} catch (NoEnergyException e) {
			e.printStackTrace();
		}
		
		try {
			p4.exercise(10);
		} catch (NoEnergyException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
