
package cc.test;

import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.*;

/**
Gets three different beans and writes their string representations
to standard output.

*/
public class TestInitialization
{
    /**
    Use a bean factory to create each of three beans and write its
    string representation to the console.
    Note that, between the IoC container handling instantiation and our
    only needing a method on Object, we have no compile-time dependency
    on the actual types of these objects.
    */
    public static void main (String[] args)
    {
        Resource configFile = new FileSystemResource ("Objects.xml");
        BeanFactory factory = new DefaultListableBeanFactory ();
        new XmlBeanDefinitionReader ((BeanDefinitionRegistry) factory)
            .loadBeanDefinitions (configFile);

        String[] names = { "Bank", "User",  "Connection2" };
        for (String name : names)
            System.out.println (factory.getBean (name));
    }
}

