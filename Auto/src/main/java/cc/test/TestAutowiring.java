
package cc.test;

import cc.*;


import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
Creates the head of each of three bean chains: beans 
{@link cc.A "A"}, {@link cc.X "X"}, and {@link cc.Q "test"}.

*/
public class TestAutowiring
{
    /**
    Use an application context to create beans "A" and "X".
    */
    public static void main (String[] args)
    {
        FileSystemXmlApplicationContext context = 
            new FileSystemXmlApplicationContext ("Objects.xml");

        A a = (A) context.getBean ("A");
        System.out.println (a.getDelegate ().getDelegate ().getValue ());

        X x = (X) context.getBean ("X");
        System.out.println (x.getDelegate ().getDelegate ().getValue ());

        Q q = (Q) context.getBean ("test");
        System.out.println (q.getDelegate ().getValue ());
    }
}

