
public class Square extends Rectangle{
	public Square(int x, int y, int w, Colour colour) {
		super(x,y,w,w,colour);
	}
	public String toString() {
		return "A " + colour + " square at (" + getX() + "," + super.getY() + ")"; 
	}
}
