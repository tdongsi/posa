
package cc.bank.test;

import cc.bank.Account;

import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.*;

/**
Creates and exercises various bank-account beans.

*/
public class TestAccounts
{
    /**
    Exercises an account object, without knowing what account type
    it's dealing with.  Makes a deposit of $50, then a withdrawal of $50,
    reporting the balance after each operation.
    Reports any InsufficientFunds exception and quits.

    @param account Target account instance upon which to operate
    */
    public static void exercise (Account account)
    {
        System.out.println ("Type is " + account.getClass ().getName ());
        System.out.format ("Starting balance is          $%,9.2f%n", 
            account.getBalance ());
        account.deposit (50);
        System.out.format ("After deposit, balance is    $%,9.2f%n", 
            account.getBalance ());
        account.withdraw (50);
        System.out.format ("After withdrawal, balance is $%,9.2f%n",
            account.getBalance ());
    }
    
    /**
    Use an XML BeanFactory to dredge up two beans, both bank accounts.
    {@link #exercise Exercise} each and write report to the console.
    */
    public static void main (String[] args)
    {
        Resource configFile = new FileSystemResource ("Accounts.xml");
        BeanFactory factory = new DefaultListableBeanFactory ();
        new XmlBeanDefinitionReader ((BeanDefinitionRegistry) factory)
            .loadBeanDefinitions (configFile);

        System.out.println ();
        System.out.println ("Creating new account for Mr. Smith ...");
        Account smith = (Account) factory.getBean ("Account");
        exercise (smith);

        System.out.println ();
        System.out.println ("Creating new account for Mr. Jones ...");
        Account jones = (Account) factory.getBean ("CheckingAccount");
        exercise (jones);
        
        System.out.println ();
        System.out.println ("Creating new account for Ms. Black ...");
        Account black = (Account) factory.getBean ("CheckingAccount");
        System.out.format 
            ("Ms. Black's balance is $%,9.2f%n", black.getBalance ());
        System.out.format 
            ("Mr. Jones's balance is $%,9.2f%n", jones.getBalance ());
        
        System.out.println ();
        System.out.println ("Ms. Black makes a deposit ...");
        black.deposit (50);
        System.out.format 
            ("Ms. Black's balance is $%,9.2f%n", black.getBalance ());
        System.out.format 
            ("Mr. Jones's balance is $%,9.2f%n", jones.getBalance ());
    }
}

