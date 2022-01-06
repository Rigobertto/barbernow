package br.com.barbernow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.barbernow.dao.ServicoDAO;
import br.com.barbernow.model.Servico;

@Controller
public class ServicoController {
	@Autowired
	private ServicoDAO servicorepositorio;
	
	@GetMapping("/servico")
	public ModelAndView servico() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Servico/servico");
		mv.addObject("servico", new Servico());
		mv.addObject("servicoList", servicorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/inserirServicos")
	public ModelAndView inserirServico(Servico servico) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Servico/cadastrar");
		mv.addObject("servico", new Servico());
		return mv;
	}
	
	@PostMapping("InsertServico")
	public ModelAndView inserirServicos(Servico servico) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/servico");
		servicorepositorio.save(servico);
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Servico/alterar");
		Servico servico = servicorepositorio.getOne(id);
		mv.addObject("servico", servico);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Servico servico) {
		ModelAndView mv = new ModelAndView();
		servicorepositorio.save(servico);
		mv.setViewName("redirect:/servico");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirServico(@PathVariable("id") Long id) {
		servicorepositorio.deleteById(id);
		return "redirect:/servico";
	}
	
	//---------------------------VIEW BARBEIRO ----------------------------
	
	@GetMapping("/servicoBarbeiro")
	public ModelAndView servicoBarbeiro() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewBarbeiro/servico");
		mv.addObject("servico", new Servico());
		mv.addObject("servicoList", servicorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/inserirServicosBarbeiro")
	public ModelAndView inserirServicoBarbeiro(Servico servico) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewBarbeiro/cadastrar");
		mv.addObject("servico", new Servico());
		return mv;
	}
	
	@PostMapping("InsertServicoBarbeiro")
	public ModelAndView inserirServicosBarbeiro(Servico servico) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/servicoBarbeiro");
		servicorepositorio.save(servico);
		return mv;
	}
	
	@GetMapping("/alterarServicoBarbeiro/{id}")
	public ModelAndView alterarServicoBarbeiro(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewBarbeiro/alterar");
		Servico servico = servicorepositorio.getOne(id);
		mv.addObject("servico", servico);
		return mv;
	}
	
	@PostMapping("/alterarServicoBarbeiro")
	public ModelAndView alterarServicoBarbeiro(Servico servico) {
		ModelAndView mv = new ModelAndView();
		servicorepositorio.save(servico);
		mv.setViewName("redirect:/servicoBarbeiro");
		return mv;
	}
	
	@GetMapping("/excluirServicoBarbeiro/{id}")
	public String excluirServicoBarbeiro(@PathVariable("id") Long id) {
		servicorepositorio.deleteById(id);
		return "redirect:/servicoBarbeiro";
	}
}
