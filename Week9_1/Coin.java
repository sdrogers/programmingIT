/**
   A coin with a monetary value.
*/
public class Coin implements Measurable
{
   private int value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin in cents
      @param aName the name of the coin
   */
   public Coin(int aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public int getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }

   public int getMeasure() 
   {
      return value;
   }
}
