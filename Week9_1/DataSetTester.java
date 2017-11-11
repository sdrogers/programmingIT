/**
   This program tests the DataSet class.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet bankData = new DataSet();
  
      BankAccount bankAccount0 = new BankAccount(0);
      BankAccount bankAccount1 = new BankAccount(10000);
      BankAccount bankAccount2 = new BankAccount(2000);

      bankData.add(bankAccount0);
      bankData.add(bankAccount1);
      bankData.add(bankAccount2);

      System.out.println("Average balance = " + bankData.getAverage());
      Measurable maxBankAccount = bankData.getMaximum();
      System.out.println("Highest balance = " + maxBankAccount.getMeasure());

      DataSet coinData = new DataSet();

      Coin coin0 = new Coin(25, "quarter");
      Coin coin1 = new Coin(10, "dime");
      Coin coin2 = new Coin(5, "nickel");

      coinData.add(coin0);
      coinData.add(coin1);
      coinData.add(coin2);

      System.out.println("Average coin value = " + coinData.getAverage());
      Measurable maxCoin = coinData.getMaximum();
      System.out.println("Highest coin value = " + maxCoin.getMeasure());

      DataSet hybridData = new DataSet();

      hybridData.add(coin0);
      hybridData.add(bankAccount2);
      hybridData.add(coin2);

      System.out.println("Average object value = " + hybridData.getAverage());
      Measurable maxObject = hybridData.getMaximum();
      System.out.println("Highest object value = " + maxObject.getMeasure());
   }
}
