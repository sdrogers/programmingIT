
public class BankAccount
{
    private int pounds = 0;
    
    private int pence = 0;
    
    private int accountNumber;
    
    private static int nextAccountNumber = 0;
    
    public BankAccount(int pnds, int pnce)
    {
        pounds = pnds;
        pence = pnce;
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
        
    }
    
    public BankAccount()
    {
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    
    public int getPounds()
    {
        return pounds;
    }
    
    public int getPence()
    {
        return pence;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    public void setPounds(int pnds)
    {
        pounds = pnds;
    }
    
    public void setPence(int pnce)
    {
        pence = pnce;
    }
    
    public static void setNextAccountNumber(int nanum)
    {
        nextAccountNumber = nanum;
    }
    
    public void print()
    {
        String line = "";
        line = String.format("The balance of account number %04d is £%02d.%02d", accountNumber, pounds, pence);
        System.out.println(line);
    }
    
    public void deposit(int pnds, int pnce)
    {
        pounds += pnds;
        pence += pnce;
    }
    
    // TODO write withdraw method
    
    public boolean equals(BankAccount other)
    {
        return accountNumber == other.getAccountNumber() && pence == other.getPence() && pounds == other.getPounds();
    }
    
    public static void main(String[] args)
    {
        BankAccount bn = new BankAccount(234, 26);
        BankAccount bn2 = new BankAccount();
        bn2.setPence(6);
        System.out.println(bn.getPounds());
        System.out.println(bn2.getAccountNumber());
        setNextAccountNumber(3);
        
        bn.print();
        bn2.print();
        
        bn2.deposit(5, 34);
        bn2.print();
        
        BankAccount bankAccount1 = new BankAccount(17, 35);
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.deposit(21, 50);
        bankAccount2.deposit(-4, -15);
        boolean isEqual = bankAccount1.equals(bankAccount2);
        System.out.println(isEqual);
        BankAccount bankAccount3 = bankAccount1;
        System.out.println(bankAccount1.equals(bankAccount3));
    }
}
