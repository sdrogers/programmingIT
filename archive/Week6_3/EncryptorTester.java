import java.io.*;
import java.util.*;

/**
   A program to test the Caesar cipher encryptor.
*/
public class EncryptorTester
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      try
      {  
         System.out.print("Input file: ");
         String inFile = in.next();
         System.out.print("Output file: ");
         String outFile = in.next();
         System.out.print("Encryption key: ");
         int key = in.nextInt();
         Encryptor crypt = new Encryptor(key);
         crypt.encryptFile(inFile, outFile);
      }
      catch (IOException exception)
      {  
         System.out.println("Error processing file: " + exception);
      }
   }
}


