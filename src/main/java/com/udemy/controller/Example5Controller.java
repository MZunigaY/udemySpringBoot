package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.Example2Service;

@Controller
@RequestMapping("/ejercicio")
public class Example5Controller {
	
	private static final Log LOG = LogFactory.getLog(Example5Controller.class);
	
	public static final String EJERCICIO_VIEW = "ejercicioservicio";
	public static final String MENSAJE = "mensaje";
	
	@Autowired
	@Qualifier("example2Service")
	private Example2Service example2Service;
	
	@GetMapping("/primerPath")
	public RedirectView primerMetodo() {
		return new RedirectView("/ejercicio/segundoPath");
	}
	
	@GetMapping("/segundoPath")
	public ModelAndView segundoMetodo() {
		ModelAndView mav = new ModelAndView();
		example2Service.mostrarMensajeLog();
		
		mav.setViewName(EJERCICIO_VIEW);
		mav.addObject("mensaje_en_controller", MENSAJE);
		
		return mav;
	}
	
}
