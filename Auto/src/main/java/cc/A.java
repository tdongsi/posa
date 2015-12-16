
package cc;

/**
An object that requires another object for construction.

*/
public class A
{
    /**
    Build an based on a delegate object.
    */
    public A (B delegate)
    {
        this.delegate = delegate;
    }
    
    /**
    Accessor for the delegate object.
    */
    public B getDelegate ()
    {
        return delegate;
    }
    
    private B delegate;
}
