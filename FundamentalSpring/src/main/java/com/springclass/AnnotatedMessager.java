package com.springclass;

import org.springframework.stereotype.Component;

@Component("annotatedmessager") 
public class AnnotatedMessager implements Messager {

	public void greet() {
		System.out.println("Hello Annotated Class");

	}

}
