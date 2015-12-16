
package cc;

/**
This class implements a simple bank account.  The account has a named holder
and a balance and offers methods to make deposits and withdrawals and to 
check the balance.
Serves as a target class for Spring IoC instantiation.

*/
public class BankAccount
{
    /**
    Build an account instance by providing the starting balance.
    */
    public BankAccount (String holder, double balance)
    {
        this.holder = holder;
        this.balance = balance;
    }
    
    public BankAccount (String holder, String x)
    {
        this.holder = holder;
     //   this.balance = balance;
    }

    /**
    Adds the passed amount to the account balance.
    */
    public void deposit (double amount)
    {
        balance += amount;
    }

    /**
    Subtracts the passed amount from the account balance.
    */
    public void withdraw (double amount)
    {
        balance -= amount;
    }

    /**
    Accessor for the balance property.
    */
    public double getBalance ()
    {
        return balance;
    }
    
    /**
    String representation just makes it easy to see what we've got.
    */
    public String toString ()
    {
        return String.format 
            ("BankAccount: %s, balance is $%,9.2f", holder, balance);
    }

    private String holder;
    private double balance;
}
