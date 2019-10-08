
public class ShapeTest {
	
	public static void main(String[] args) {
		Colour pink = new Colour(180,0,0);
		Rectangle r = new Rectangle(20,100,5,10,pink);
		System.out.println(r);
		Colour yellow = new Colour(0,255,255);
		Ellipse e = new Ellipse(100,5,30,6,yellow);
		System.out.println(e);
		e.move(10, 10);
		System.out.println(e);
		
		Rectangle g = new Rectangle(0,0,10,10,new Colour(0,0,0));
		Ellipse h = new Ellipse(0,0,10,10,new Colour(255,255,255));
		System.out.println(g.compArea());
		System.out.println(h.compArea());
		Colour blue = new Colour(0,0,255);
		Square s = new Square(10,30,40,blue);
		System.out.println(s.compArea());
	}

}
