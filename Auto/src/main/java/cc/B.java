package cc;

public class B
{
    /**
    Build an based on a delegate object.
    */
    public B (C delegate)
    {
        this.delegate = delegate;
    }
    
    /**
    Accessor for the delegate object.
    */
    public C getDelegate ()
    {
        return delegate;
    }
    
    private C delegate;
}
