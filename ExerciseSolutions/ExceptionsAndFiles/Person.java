/*
 * Solution to part 1 (People)
 */
public class Person {
	private String name;
	private int age;
	private String eyeColour;
	public Person(String name,int age,String eyeColour) {
		this.setName(name);
		this.setAge(age);
		this.setEyeColour(eyeColour);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return name + " (age " + age + ") has " + eyeColour + " eyes.";
	}
	public String getEyeColour() {
		return eyeColour;
	}
	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}
}
