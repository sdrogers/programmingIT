/**
   This program tests the permutation generator.
*/

import java.util.*;

public class PermutationGeneratorTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a word: ");
      String word = in.next();
      PermutationGenerator generator = new PermutationGenerator(word);
      String [] permutations = generator.getPermutations();
      for (String s : permutations)         
         System.out.println(s);
   }
}
