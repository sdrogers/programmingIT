
public class MyObject implements Comparable<MyObject>{
	private int a;
	public MyObject(int a) {
		this.a = a;
	}
	public int getA() {
		return a;
	}
	public int compareTo(MyObject other) {
		if(this.a > other.a) {
			return -1;
		}else if(this.a < other.a) {
			return 1;
		}else {
			return 0;
		}
	}
	public String toString() {
		return ""+a;
	}
}
