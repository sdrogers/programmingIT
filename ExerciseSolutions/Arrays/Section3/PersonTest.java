public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person("Simon",4);
		System.out.println(p);

		p.addChild(new Person("Ella",2));
		System.out.println(p);
		p.addChild(new Person("Matthew",1));
		System.out.println(p);

		// Now add a third
		p.addChild(new Person("Clive",11));
		System.out.println(p);

		// Now add a fourth -- it will make a bigger array
		p.addChild(new Person("Rebecca",1111));
		System.out.println(p);


	}
}