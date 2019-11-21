public class extraExamples {

	public static String asterisks(int n){
		if(n==0) return "";
		else return "*" + asterisks(n-1);
	}
	
	public static String vertical(String s){
		if(s.length()==0) return "";
		else return "" + s.charAt(0) + "\n" + vertical(s.substring(1));
	}
	
	public static int recursivePower(int b, int n){
		if(n==0) return 1;
		return b*recursivePower(b,n-1);
	}
	
	public static String backwards(String s){
		if(s.length()==0) return "";
		return "" + s.charAt(s.length()-1) + backwards(s.substring(0,s.length()-1));
	}
	
	public static int sumOfSquares(int n){
		if(n<=1) return n;
		return n*n + sumOfSquares(n-1);
	}

	public static void main(String[] args) {
		//Test first method
		System.out.println(asterisks(9));
		//Test second method
		System.out.println(vertical("absolutely"));
		//Test third method
		int b1 = 7;
		int n1 = 4;
		System.out.println(b1 + " to the " + n1 + " is " + recursivePower(b1,n1));
		//Test fourth method
		System.out.println(backwards("fabulous"));
		//Test fifth method
		System.out.println(sumOfSquares(6));

	}

}
