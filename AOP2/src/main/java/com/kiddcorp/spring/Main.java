package com.kiddcorp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kiddcorp.spring.service.ExampleService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ExampleService exampleBean = (ExampleService) ctx
				.getBean("exampleService");

		exampleBean.simpleMethod();
		Object result = exampleBean.methodReturnsValue();
		try {
			exampleBean.methodThrowsException();
		} catch (Exception e) {
			System.out.println("Exception caught in Main: " + e.getMessage());
		}
		result = exampleBean.testAroundReturningResult();
		try {
			exampleBean.testAroundThrowingException();
		} catch (Exception e) {
			System.out.println("Exception caught in Main: " + e.getMessage());
		}

	}
}
