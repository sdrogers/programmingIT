
public class ScopeTest {
	private String name;
	public String appendString(String s) {
		String name = "Simon";
		name += s;
		return name; 
	}
	public void printString() {
		System.out.println(name);
	}
	public static void main(String[] args) {
		ScopeTest s = new ScopeTest();
		s.appendString("alsjlaksd");
		s.printString();
	}
}
