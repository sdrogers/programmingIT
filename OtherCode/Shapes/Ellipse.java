
public class Ellipse extends Shape {
	public Ellipse(int x,int y,int w, int h, Colour colour) {
		super(x,y,w,h,colour);
	}
	public String toString() {
		return "A " + colour + " ellipse at (" + getX() + "," + super.getY() + ")"; 
	}
	public double compArea() {
		return getW()*getH()*Math.PI;
	}
	
}
