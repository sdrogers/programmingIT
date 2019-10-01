
public class Immutable {
	public static void changeObjects(SimpleObject g) {
		g.setA(10);
	}
	
	public static String changeString(String g) {
		g += " hello";
		return g;
	}
	public static void main(String[] args) {
		SimpleObject s = new SimpleObject();
		s.setA(5);
		System.out.println(s.getA());
		
		changeObjects(s);
		System.out.println(s.getA());
		
		
		String t = "it's nice to say ";
		String u = changeString(t);
		System.out.println(t);
		System.out.println(u);
	}
}
