
package cc.bank;

/**
This class implements a checking account, which is a specialization
of an ordinary Account that imposes per-transaction fees if a
minimum balance is not kept.

*/
public class FeeAccount
    extends Account
{
    private static final double DEFAULT_MINIMUM_BALANCE = 3000.00;
    private static final double DEFAULT_TRANSACTION_FEE = 2.50;

    private double minimumBalance = DEFAULT_MINIMUM_BALANCE;
    private double transactionFee = DEFAULT_TRANSACTION_FEE;

    /**
    Build a checking account instance by providing the 
    transaction-fee amount and threshold.
    */
    public FeeAccount (double minimumBalance, double transactionFee)
    {
        this.minimumBalance = minimumBalance;
        this.transactionFee = transactionFee;
    }

    /**
    Build an account instance with the default fee structure.
    */
    public FeeAccount ()
    {
    }

    /**
    Helper method to impose the standard transaction fee.
    */
    protected void imposeTransactionFee ()
    {
        if (getBalance () < minimumBalance)
            super.withdraw (transactionFee);
    }

    /**
    Adds the passed amount to the account balance, after imposing
    transaction fee.
    */
    public void deposit (double amount)
    {
        imposeTransactionFee ();
        super.deposit (amount);
    }

    /**
    Subtracts the passed amount from the account balance, and imposes the
    transaction fee.
    */
    public void withdraw (double amount)
    {
        super.withdraw (amount);
        imposeTransactionFee ();
    }
}

