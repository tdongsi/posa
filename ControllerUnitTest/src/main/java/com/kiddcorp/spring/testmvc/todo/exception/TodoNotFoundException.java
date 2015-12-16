package com.kiddcorp.spring.testmvc.todo.exception;

/**
 * @author John Kidd
 */
public class TodoNotFoundException extends Exception {

    public TodoNotFoundException(String message) {
        super(message);
    }

}
