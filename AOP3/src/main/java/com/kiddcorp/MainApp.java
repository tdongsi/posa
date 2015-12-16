package com.kiddcorp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("appContext.xml");

      Student student = (Student) context.getBean("student");

      student.getName();
      student.getAge();
      
      try {
		student.printThrowException();
	} catch (Exception e) {
		//wdc
	}
      
      try {
  		student.printSQLThrowException();;
  	} catch (Exception e) {
  		//wdc
  	}
   }
}