
public class Shape {
	protected Colour colour;
	private int x,y,w,h;
	public Shape(int x, int y, int w, int h,Colour colour) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.colour = colour;
	}
	public double compArea() {
		return 0.0;
	}
	public Colour getColour() {
		return colour;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public void move(int dx,int dy) {
		x += dx;
		y += dy;
	}
	public String toString() {
		return "A " + colour + " shape at (" + x + "," + y + ")"; 
	}
}
