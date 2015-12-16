
package cc;

/**
An object that requires another object for construction.

*/
public class Q
{
    /**
    Build an based on a delegate object.
    */
    @javax.annotation.Resource (name="r")
    public void setDelegate (R delegate)
    {
        this.delegate = delegate;
    }
    
    /**
    Accessor for the delegate object.
    */
    public R getDelegate ()
    {
        return delegate;
    }
    
    private R delegate;
}
