package com.springclass;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	public static void main(String[] args) {
		String springConfig = "com/springclass/spring-config.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(springConfig);
		
		MessageLooper messageLooper = (MessageLooper) spring.getBean("messageLooper");
		messageLooper.doIt();
	}
}