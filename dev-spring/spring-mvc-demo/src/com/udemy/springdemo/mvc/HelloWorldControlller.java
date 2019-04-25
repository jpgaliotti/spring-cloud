package com.udemy.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldControlller {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// a new controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormV2")
	public String letsShout(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey! " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// using annotation for get the request parameters
	@RequestMapping("/processFormV3")
	public String processFormV3(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey my friend from V3! " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
