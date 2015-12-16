package com.kiddcorp.web.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.kiddcorp.web.exception.CustomGenericException;
 
@ControllerAdvice
public class GlobalExceptionController {
 
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
 
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("exception", ex);
 
		return model;
 
	}
 
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
 
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");
 
		return model;
 
	}
 
}