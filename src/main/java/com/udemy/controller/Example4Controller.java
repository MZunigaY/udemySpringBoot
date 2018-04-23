package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	private final String ERROR_404 = "404";
	private final String ERROR_500 = "500";
	
	@GetMapping("/error404")
	public ModelAndView error404() {
		ModelAndView mav = new ModelAndView(ERROR_404);
		return mav;
	}
	
	@GetMapping("/error500")
	public String error500() {
		return ERROR_500;
	}
}
