import MyPackage.Pet;
import MyPackage.Dog;
import MyPackage.LazyDog;
import java.util.Arrays;
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
		//		
		Cat c = new Cat("Flo",2);
		c.sayHello();
		c.feed(100);

		d.chase(c);
		//		p2.chase(c); //Doesn't work!
		((Dog)p2).chase(c); // does work, but looks horrid
		//		
		Pet p3 = new Cat("Lou",3);
		//		d.chase(p3); //Doesn't work!
		//		but you can cast
		d.chase((Cat)p3);
		//		
		//		
		LazyDog l = new LazyDog("Clive",25);
		l.exercise(10);
		//		
		//		Look at this crazy polymorphism! We can store a LazyDog object with a reference type anywhere higher up the hierarchy!
		Dog d2 = l;
		Pet p4 = l;
		Object o = l;
		//		
		// And calling the exercise method from the LazyDog ref is like this
		l.exercise(10);
		//		
		//		// But if from the Dog or Pet, we need to handle the exception
		//		// even though it is the method version in lazy dog that is used! 
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



		Pet[] petArray = new Pet[3];
		petArray[0] = d;
		petArray[1] = c;
		petArray[2] = new LazyDog("Colin",12);
		petArray[1] = p3;
		for(Pet zz: petArray) {
			zz.sayHello();
		}
		// We can sort them, because Pet implements comparable
		Arrays.sort(petArray);
		for(Pet zz: petArray) {
			zz.sayHello();
		}



		Dog[] dArray = new Dog[3];
		dArray[0] = new Dog("a",5);
		dArray[1] = new Dog("b",2);
		dArray[2] = new Dog("c",1);

		// We can also sort an array of Dogs because they inherit the comparable method from Pet
		Arrays.sort(dArray);

		for(Dog dd: dArray) {
			System.out.println(dd.getName());
		}
	}
}
