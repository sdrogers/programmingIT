public class Question2 {
	public static void main(String[] args) {
		doubleTable(45.23,99);
	}
	public static void doubleTable(double v, int max) {
		/* 
			I have put the checking in a separate method
			(neater). It returns true if the values are in the
			correct range, false otherwise. If we get false
			we just return from this method. Note that it
			is perfectly ok to use return (with nothing after it)
			to return from a method that is 'void'. (previously we
			only saw return when the method was not void).
		*/
		if(!check(v,max)) {
			return;
		}
		for(int i=1;i<=max;i++) {
			double result = v*i;
			String line = String.format("%6.2f x %2d = %9.3f",v,i,result);
			System.out.println(line);
		}
	}
	public static boolean check(double v, int max) {
		if(max < 0 || max > 99) {
			return false;
		}
		if(v < 0.0 || v > 99.0) {
			return false;
		}
		return true;
	}
}