package MyPackage;
/**
 * A Lazy dog, extends dog and doesn't like exercise
 * @author simon
 *
 */
public class LazyDog extends Dog {

	public LazyDog(String name, int age) {
		super(name, age);
	}
	/**
	 * Lazy dogs don't like exercise
	 */
	public void exercise(int energy) {
		System.out.println(name + " doesn't do exercise, too lazy");
	}
	
}
