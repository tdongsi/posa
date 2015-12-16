package com.kiddcorp.pointcut.within;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kiddcorp.CustomerQuery;

public class Main {
  
  public static void main(String[]args) throws Exception{
    
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(new String[]{
      "/com/kiddcorp/pointcut/within/aopContext.xml",
      "/appContext.xml"});
       
    CustomerQuery query = (CustomerQuery) beanFactory.getBean("customerQuery");
    
    query.getCustomerByName("Java Joe");
    
  }
  
}
