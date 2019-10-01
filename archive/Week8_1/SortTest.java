import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		MyObject[] o = new MyObject[5];
		int[] i_vals = {10,4,7,8,1};
		System.out.println("Before sorting");
		for(int i=0;i<5;i++) {
			o[i] = new MyObject(i_vals[i]);
		}
		for(int i=0;i<5;i++) {
			System.out.println(o[i].getA());
		}
		System.out.println("After sorting");
		Arrays.sort(o);
		for(int i=0;i<5;i++) {
			System.out.println(o[i].getA());
		}
		
		System.out.println(o[0]);
	}
}
