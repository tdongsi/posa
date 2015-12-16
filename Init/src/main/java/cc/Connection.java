
package cc;

/**
A connection class for some protocol, perhaps a chat: involves address,
mode (duplex or half), and connection retries.  
Serves as a target class for Spring IoC instantiation.

*/
public class Connection
{
    /**
    Defaults to duplex mode, no retries.
    */
    public Connection (String address)
    {
 //       this (address, "duplex");
    }

    /**
    Defaults to duplex mode.
    */
    public Connection (String address, int retries)
    {
        this (address, "duplex", retries);
    }

    /**
    Defaults to no retries.
    */
//    public Connection (String address, String mode)
//    {
//        this (address, mode, 0);
//    }

    /**
    Initializes all fields explicitly.
    */
    public Connection (String address, String mode, int retries)
    {
        this.address = address;
        this.mode = mode;
        this.retries = retries;
    }
    
    /**
    String representation just makes it easy to see what we've got.
    */
    public String toString ()
    {
        return "Connection: " + address + ", " + mode + ", " + 
            retries + " retries.";
    }

    private String address;
    private String mode;
    private int retries;
}
