import java.util.Random;
public class Parts1And2 {
    public static void main(String[] args) {
        Random r = new Random();
        double[] rA = new double[100];
        for(int i=0;i<rA.length;i++) {
            rA[i] = r.nextDouble();
        }
        // Print the mean
        System.out.println(mean(rA));
    }
    public static double mean(double[] arr) {
        double total = 0.0;
        for(int i=0;i<arr.length;i++) {
            total += arr[i];
        }
        return total/arr.length;
    }
}