package br.com.barbernow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.barbernow.dao.ClienteDAO;
import br.com.barbernow.enums.Cargo;
import br.com.barbernow.model.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private ClienteDAO clienterepositorio;
	Cargo cargo;
	
	@GetMapping("/cliente")
	public ModelAndView cliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cliente/cliente");
		mv.addObject("cliente", new Cliente());
		mv.addObject("clienteList", clienterepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/inserirClientes")
	public ModelAndView inserirCliente(Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cliente/cadastrar");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@PostMapping("InsertCliente")
	public ModelAndView inserirClientes(Cliente cliente) {
		cliente.setCargo(cargo.CLIENTE);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/cliente");
		clienterepositorio.save(cliente);
		return mv;
	}
	
	@GetMapping("/alterarCliente/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cliente/alterar");
		Cliente cliente= clienterepositorio.getOne(id);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/alterarCliente")
	public ModelAndView alterar(Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		clienterepositorio.save(cliente);
		mv.setViewName("redirect:/cliente");
		return mv;
	}
	
	@GetMapping("/excluirCliente/{id}")
	public String excluirCliente(@PathVariable("id") Long id) {
		clienterepositorio.deleteById(id);
		return "redirect:/cliente";
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cliente", new Cliente());
		mv.setViewName("Login/cadastro");
		return mv;
	}
	
	@PostMapping("InsertClienteCadastro")
	public ModelAndView cadastroClientes(Cliente cliente) {
		cliente.setCargo(cargo.CLIENTE);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		clienterepositorio.save(cliente);
		return mv;
	}
	
	// ----------------------------- VIEW CLIENTE ---------------------------------------
	
	
}
