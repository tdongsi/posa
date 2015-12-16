
package cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
An object that requires another object for construction.

*/
@Component
public class Y
{
    /**
    Build an based on a delegate object.
    */
    @Autowired
    public Y (Z delegate)
    {
        this.delegate = delegate;
    }
    
    /**
    Accessor for the delegate object.
    */
    public Z getDelegate ()
    {
        return delegate;
    }
    
    private Z delegate;
}
