
package cc.test;

import cc.Registry;

import org.springframework.core.io.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.*;

/**
Gets the same bean twice, to see if it is really a singleton or a prototype.

*/
public class TestRegistry
{
    /**
    Use an XML BeanFactory to create two instances of the registry class --
    in spite of the fact that the class is designed as a singleton.
    */
    public static void main (String[] args)
    {
        Resource configFile = new FileSystemResource ("Objects.xml");
        BeanFactory factory = new DefaultListableBeanFactory ();
        new XmlBeanDefinitionReader ((BeanDefinitionRegistry) factory)
            .loadBeanDefinitions (configFile);
        
        System.out.println("About to ask for bean...");
        Registry reg1 = (Registry) factory.getBean ("Registry");
        Registry reg2 = (Registry) factory.getBean ("Registry");
        
        reg1.put ("Name1", "Value1");
        reg2.put ("Name2", "Value2");
        
        System.out.println(reg1);
        System.out.println(reg2);
        
//        Registry r=Registry.getInstance();
//        System.out.println(r);
    }
}

