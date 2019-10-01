/** 
 Class to illustrate a rounding error
 */

public class RoundingError
{
   public static void main(String[] args)
   {
      double f = 4.35;
      double g = 100.0*f;
      System.out.println("4.35 * 100 equals: "+g);
      int h = (int) g;
      System.out.println("4.35 * 100 equals: "+h);
   }
}
