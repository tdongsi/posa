
package cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
An object that requires another object for construction.

*/
@Component ("X")
public class X
{
    /**
    Build an based on a delegate object.
    */
    @Autowired
    public X (Y delegate)
    {
        this.delegate = delegate;
    }
    
    /**
    Accessor for the delegate object.
    */
    public Y getDelegate ()
    {
        return delegate;
    }
    
    private Y delegate;
}
