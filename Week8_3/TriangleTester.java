import java.util.Scanner;

public class TriangleTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter width: ");
      int width = in.nextInt();
      Triangle t = new Triangle(width);
      int area = t.getArea();
      System.out.println("Area = " + area);
   }
}
