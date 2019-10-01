public class Question1 {
	public static void main(String[] args) {
		doubleTable(45.23,98);
	}
	public static void doubleTable(double v, int max) {
		for(int i=1;i<=max;i++) {
			double result = v*i;
			String line = String.format("%6.2f x %2d = %9.3f",v,i,result);
			System.out.println(line);
		}
	}
}