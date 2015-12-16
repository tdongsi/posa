package com.kiddcorp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.kiddcorp.web.exception.CustomGenericException;

@Controller
public class CustomerController extends AbstractController {

	@Override
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		throw new CustomGenericException("E999", "This is custom message X");

	}

}