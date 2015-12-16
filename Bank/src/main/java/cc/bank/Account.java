
package cc.bank;

/**
This class implements a simple bank account.  The account holds a balance
and offers methods to make deposits and withdrawals and to check the balance.

*/
public class Account
{
    private double balance = 100;
    
    /**
    Mutator for initial balance.
    */
    public void setInitialBalance (double balance)
    {
        this.balance = balance;
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
}
