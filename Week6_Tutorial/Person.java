import FormatIO.Console;

public class Person {
	private String firstname;
	private String lastname;
	private MyDate dOB;
	
	//Assuming here that the DoB is passed in as a mydate object
	//alternative would be that the day month year could
	//be passed in and the MyDate instantiated here
	public Person(String f,String l,MyDate d) {
		firstname = f;
		lastname = l;
		dOB = d;
	}
	
	public String getFirstName() { return firstname;}
	public String getLastName() { return lastname;}
	public MyDate getDob() { return dOB;} // Note the return type (MyDate)
	
	public void print(Console c) {
		// Put the names and things into a single string
		String d = firstname + " " + lastname;
		d += ": born on ";
		// Print d on the console
		c.print(d); // Note not println to keep this and the dOB on the same line
		// call the MyDate print method to print the date...
		// ...we have to pass it the console
		dOB.print(c);
	}
	
	public int age(MyDate now) {
		return dOB.differenceInYears(now);
	}
	
	public static void main(String[] args) {
		// Have to make the date before the person...
		MyDate m = new MyDate(01,10,75);
		// ...as the person constructor needs the date 
		Person p = new Person("Ken","Geoffries",m);
		Console c = new Console();
		p.print(c);
		
		MyDate today = new MyDate(23,10,17);
		System.out.println(p.age(today));
	}
}
