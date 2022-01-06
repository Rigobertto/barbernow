package br.com.barbernow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.barbernow.dao.BarbeiroDAO;
import br.com.barbernow.enums.Cargo;
import br.com.barbernow.model.Barbeiro;

@Controller
public class BarbeiroController {
	@Autowired
	private BarbeiroDAO barbeirorepositorio;
	Cargo cargo;
	
	@GetMapping("/barbeiro")
	public ModelAndView barbeiro() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Barbeiro/barbeiro");
		mv.addObject("barbeiro", new Barbeiro());
		mv.addObject("barbeiroList", barbeirorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/inserirBarbeiros")
	public ModelAndView inserirBarbeiro(Barbeiro barbeiro) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Barbeiro/cadastrar");
		mv.addObject("barbeiro", new Barbeiro());
		return mv;
	}
	
	@PostMapping("InsertBarbeiro")
	public ModelAndView inserirBarbeiros(Barbeiro barbeiro) {
		barbeiro.setCargo(cargo.BARBEIRO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/barbeiro");
		barbeirorepositorio.save(barbeiro);
		return mv;
	}
	
	@GetMapping("/alterarBarbeiro/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Barbeiro/alterar");
		Barbeiro barbeiro = barbeirorepositorio.getOne(id);
		mv.addObject("barbeiro", barbeiro);
		return mv;
	}
	
	@PostMapping("/alterarBarbeiro")
	public ModelAndView alterar(Barbeiro barbeiro) {
		ModelAndView mv = new ModelAndView();
		barbeirorepositorio.save(barbeiro);
		mv.setViewName("redirect:/barbeiro");
		return mv;
	}
	
	@GetMapping("/excluirBarbeiro/{id}")
	public String excluirBarbeiro(@PathVariable("id") Long id) {
		barbeirorepositorio.deleteById(id);
		return "redirect:/barbeiro";
	}
}
