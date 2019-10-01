/**
   This class generates permutations of a word.
*/
public class PermutationGenerator
{
   private String word;
   private int permLen;

   /**
      Constructs a permutation generator.
      @param aWord the word to permute
   */
   public PermutationGenerator(String aWord)
   {
      word = aWord;
      Factorial wordFactorial = new Factorial(word.length());
      permLen = (int) wordFactorial.getFactorial();
   }

   /**
      Gets all permutations of a given word.
   */
   public String [] getPermutations()
   {
      String [] result = new String[permLen];

      // The empty string has a single permutation: itself
      if (word.length() == 1) 
      { 
         result[0] = word;
         return result;
      }

      int runningTotal = 0;
      // Loop through all character positions
      for (int i = 0; i < word.length(); i++)
      {
         // Form a simpler word by removing the ith character
         String shorterWord = word.substring(0, i)
               + word.substring(i + 1);

         // Generate all permutations of the simpler word
         PermutationGenerator shorterPermutationGenerator 
               = new PermutationGenerator(shorterWord);
         String [] shorterWordPermutations 
               = shorterPermutationGenerator.getPermutations();

         // Add the removed character to the front of
         // each permutation of the simpler word, 
         for (String s : shorterWordPermutations)
         {
            result[runningTotal]=word.charAt(i) + s;
            runningTotal++;
         }
      }
      // Return all permutations
      return result;
   }
}
