
package cc.spring.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
Controller that exercises a {@link cc.spring.MyClass MyClass} object.
*/
public class TestLifecycle
{
    /**
    Just instantiates a bean named "myBean".
    */
    public static void main (String[] args)
    {
//        Resource configFile = new FileSystemResource ("Objects.xml");
//        BeanFactory factory = new DefaultListableBeanFactory ();
//        new XmlBeanDefinitionReader ((BeanDefinitionRegistry) factory)
//            .loadBeanDefinitions (configFile);
        
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext
        		("Objects.xml");
        context.getBean ("myBean");
        
        context.close();
    }
}

