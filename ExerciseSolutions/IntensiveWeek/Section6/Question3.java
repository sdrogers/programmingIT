public class Question3 { 
	public static void main(String[] args) {
		listPrimes(1000);
	}
	public static void listPrimes(int n) {
		/*
		 * Lists all primes from 2 to n (inclusive)
		 */
		for(int i=2;i<=n;i++) {
			if(isPrime(i)) {
				String line = String.format("%5d is a prime number", i);
				System.out.println(line);
			}
		}
	}
	public static boolean isPrime(int m) {
		// assumes n >= 2
		for(int i=2;i<m;i++) {
			if(m % i == 0) {
				return false;
			}
		}
		/*
		 * Only gets here if not divisible by
		 * anything from 2 to n-1
		 */
		return true;
	}
}
