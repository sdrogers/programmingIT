
public class Colour {
	private int r,g,b;
	public Colour(int r, int g, int b) {
		this.r = r;this.b = b;this.g=g;
	}
	public String toString() {
		return String.format("(%d,%d,%d)",r,g,b);
	}
}
