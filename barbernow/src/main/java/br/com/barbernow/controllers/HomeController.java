package br.com.barbernow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		//mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("/navbar")
	public ModelAndView navBar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Fragmentos/navbar");
		//mv.addObject("aluno", new Aluno());
		return mv;
	}
}
