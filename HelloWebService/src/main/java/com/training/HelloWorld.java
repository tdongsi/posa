package com.training;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloWorld {
	@GET
	public String greet() {
		return "Hello!";
	}

	@POST
	public String setMessage(@QueryParam("msg") String message) {
		return "Message is " + message;
	}
}
