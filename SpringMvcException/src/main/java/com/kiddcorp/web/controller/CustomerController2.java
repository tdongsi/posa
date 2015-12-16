package com.kiddcorp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kiddcorp.web.exception.CustomGenericException;

@Controller
public class CustomerController2 {

	@RequestMapping(value = "/customer2", method = RequestMethod.GET)
	public ModelAndView getPages() throws Exception {

		throw new CustomGenericException("E888", "This is custom message X");

	}

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("exception", ex);

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		
		return model;

	}

}
