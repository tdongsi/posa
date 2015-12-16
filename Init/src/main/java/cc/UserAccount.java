
package cc;

/**
User account that captures user name and password.
Serves as a target class for Spring IoC instantiation.

*/
public class UserAccount
{
    /**
    Provide both strings to initialize the account.
    */
    public UserAccount (String user, String password)
    {
        this.user = user;
        this.password = password;
    }

    /**
    String representation just makes it easy to see what we've got.
    */
    public String toString ()
    {
        return "UserAccount: name is " + user;
    }

    private String user;
    
    @SuppressWarnings("unused")
    private String password;
}

