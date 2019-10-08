
public class Rectangle extends Shape {
	public Rectangle(int x,int y,int w, int h, Colour colour) {
		super(x,y,w,h,colour);
	}
	public String toString() {
		return "A " + colour + " rectangle at (" + getX() + "," + super.getY() + ")"; 
	}
	public double compArea() {
		return getW()*getH();
	}
}
