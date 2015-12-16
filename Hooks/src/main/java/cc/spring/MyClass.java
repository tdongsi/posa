package cc.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
Prototypical class with various lifecycle hooks.
*/
public class MyClass
    implements InitializingBean, DisposableBean, BeanFactoryAware
{
    /**
    Annotation-driven initialization hook.
    */
    @PostConstruct
    public void postConstruct ()
    {
        System.out.println ("postConstruct() called.");
    }

    /**
    Annotation-driven destruction hook.
    */
    @PreDestroy
    public void preDestroy ()
    {
        System.out.println ("preDestroy() called.");
    }

    /**
    Declared destruction hook; also the reflection-driven hook method.
    */
    public void init ()
    {
        System.out.println ("init() called.");
    }

    /**
    Annotation-driven initialization hook.
    */
    public void destroy ()
    {
        System.out.println ("destroy() called.");
    }

    /**
    Reflection-driven initialization hook.
    */
    public void afterPropertiesSet ()
    {
        System.out.println ("afterPropertiesSet() called.");
    }
    
    /**
    Accessor for myProperty property.
    */
    public String getMyProperty ()
    {
        return myProperty;
    }
    
    /**
    Mutator for myProperty property.
    */
    public void setMyProperty (String newValue)
    {
        System.out.println ("setMyProperty() called.");
        myProperty = newValue;
    }
    
    private String myProperty;

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}
}

