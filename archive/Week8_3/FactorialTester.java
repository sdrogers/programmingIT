import java.util.Scanner;

public class FactorialTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a positive integer: ");
      int num = in.nextInt();
      Factorial t = new Factorial(num);
      double factorial = t.getFactorial();
      System.out.println(num+"! = " + factorial);
   }
}
