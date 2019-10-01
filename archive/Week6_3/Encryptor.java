import java.io.*;

/**
   An encryptor encrypts files using the Caesar cipher.
   For decryption, use an encryptor whose key is the 
   negative of the encryption key.
*/
public class Encryptor
{

   private int key;

   /**
      Constructs an encryptor.
      @param aKey the encryption key
   */
   public Encryptor(int aKey)
   {
      key = aKey;
   }

   /**
      Encrypts the contents of a file.
      @param inFile the input file
      @param outFile the output file
   */
   public void encryptFile(String inFile, String outFile)
         throws IOException
   {
      FileInputStream in = null;
      FileOutputStream out = null;

      try
      {
         in = new FileInputStream(inFile);
         out = new FileOutputStream(outFile);
         encryptStream(in, out);
      }
      finally
      {
         if (in != null) in.close();
         if (out != null) out.close();
      }      
   }

   /**
      Encrypts the contents of a stream.
      @param in the input stream
      @param out the output stream
   */      
   public void encryptStream(FileInputStream in, FileOutputStream out)
         throws IOException
   {
      boolean done = false;
      while (!done)
      {
         int next = in.read();
         if (next == -1) done = true;
         else
         {
            byte b = (byte) next;
            byte c = encrypt(b);
            out.write(c);
         }
      }
   }

   /**
      Encrypts a byte.
      @param b the byte to encrypt
      @return the encrypted byte
   */
   public byte encrypt(byte b)
   {
      return (byte) (b + key);
   }
}
