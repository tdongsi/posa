
package cc;

/**
An object that requires a string value for construction.

*/
public class R
{
    /**
    Build an based on a string value.
    */
    public R (String value)
    {
        this.value = value;
    }
    
    /**
    Accessor for the string value.
    */
    public String getValue ()
    {
        return value;
    }
    
    private String value;
}
