public class Person {
	private String name;
	private int age;
	private Person[] children;
	private int maxChildren = 3;
	private int nChildren = 0;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
		children = new Person[maxChildren];
	}
	public String getName() {
		return name;
	}
	public String toString() {
		String line = name + " (" + age + ")";
		if(nChildren > 0) {
			line += " has children:";
			for(int i=0;i<nChildren;i++) {
				line += " " + children[i].toString(); 
			}
		}
		return line;
	}
	public void addChild(Person child) {
		if(nChildren < maxChildren) {
			// Still space in the aray
			children[nChildren++] = child;
		}else {
			// Going to need a bigger boat...
			maxChildren *= 2; // double the capacity
			Person[] temp = new Person[maxChildren]; // new array, temporary reference
			for(int i=0;i<nChildren;i++) {
				temp[i] = children[i]; // copy from old to new
			}
			children = temp; // shift the reference
			addChild(child); // call add child from inside addChild! Crazy! Now there will be space
		}
	}
}