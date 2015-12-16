
package cc;

/**
An object that requires a string value for construction.

*/
public class C
{
    /**
    Build an based on a string value.
    */
    public C (String value)
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
