package br.com.barbernow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.barbernow.dao.AgendamentoDAO;
import br.com.barbernow.dao.ClienteDAO;
import br.com.barbernow.dao.ServicoDAO;
import br.com.barbernow.exception.ServiceExc;
import br.com.barbernow.model.Agendamento;
import br.com.barbernow.model.Cliente;
import br.com.barbernow.model.Servico;
import br.com.barbernow.model.Usuario;
import br.com.barbernow.service.ClienteService;

@Controller
public class AgendamentoController {
	
	@Autowired
	ServicoDAO servicoRepositorio;
	
	@Autowired
	AgendamentoDAO agendamentoRepositorio;
	
	@Autowired
	ClienteDAO clienteRepositorio;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/agendamento")
	public ModelAndView agendamento() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Agendamento/agendamento");
		mv.addObject("agendamento", new Servico());
		mv.addObject("agendamentoList", agendamentoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/inserirAgendamento")
	public ModelAndView inserirAgendamento(Agendamento agendamento) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Agendamento/cadastrar");
		mv.addObject("agendamento", new Agendamento());
		mv.addObject("servicos", servicoRepositorio.findAll());
		mv.addObject("clientes", clienteRepositorio.findAll());
		return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView membro(Servico servico){
		ModelAndView mv =new ModelAndView("Agendamento/cadastrar");
		mv.addObject(servico);
		mv.addObject("servicos", servicoRepositorio.findAll());
		return mv; 
	}
	
	
	
	//---------------------------------------- VIEW PARA CLIENTE -------------------------------------
	
	@GetMapping("/agendamentoCliente")
	public ModelAndView agendamentoCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewCliente/agendamento");
		mv.addObject("agendamento", new Servico());
		mv.addObject("agendamentoList", agendamentoRepositorio.findAll());
		return mv;
	}
	
	@PostMapping("InsertAgendamento")
	public ModelAndView insertAgendamento(Agendamento agendamento, Servico servico, Cliente cliente) throws ServiceExc {
		
		agendamento.setServico(servico);
		agendamento.setClientes(cliente);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/agendamento");
		agendamentoRepositorio.save(agendamento);
		return mv;
	}
	
	@GetMapping("/inserirAgendamentoCliente")
	public ModelAndView inserirAgendamentoCliente(Agendamento agendamento, Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewCliente/cadastrarAgendamento");
		mv.addObject("agendamento", new Agendamento());
		mv.addObject("cliente", new Cliente());
		mv.addObject("servicos", servicoRepositorio.findAll());
		return mv;
	}
	
	@PostMapping("InsertAgendamentoCliente")
	public ModelAndView insertAgendamentoCliente(Agendamento agendamento, Servico servico, Cliente cliente) throws ServiceExc {

		//agendamento.setServico(servico);
		Cliente clienteLogado = clienteService.loginUser(agendamento.getLogin());
		
		System.out.println(clienteLogado.getId());
		agendamento.setServico(servico);
		
		//clienteLogado.getAgendamento().add(agendamento);
		agendamento.setClientes(clienteLogado);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/agendamentoCliente");
		agendamentoRepositorio.save(agendamento);
		//clienteRepositorio.save(cliente);
		return mv;
	}
	
	@GetMapping("/excluirAgendamentoCliente/{id}")
	public String excluirCliente(@PathVariable("id") Long id) {
		agendamentoRepositorio.deleteById(id);
		return "redirect:/agendamentoCliente";
	}
	
	@GetMapping("/alterarAgendamentoCliente/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("servicos", servicoRepositorio.findAll());
		mv.setViewName("ViewCliente/alterarAgendamento");
		
		Agendamento agendamento= agendamentoRepositorio.getOne(id);
		mv.addObject("agendamento", agendamento);
		return mv;
	}
	
	@PostMapping("/alterarAgendamentoCliente")
	public ModelAndView alterar(Agendamento agendamento, Servico servico) throws ServiceExc {
		Cliente clienteLogado = clienteService.loginUser(agendamento.getLogin());
		agendamento.setServico(servico);
		
		agendamento.setClientes(clienteLogado);
		ModelAndView mv = new ModelAndView();
		agendamentoRepositorio.save(agendamento);
		mv.setViewName("redirect:/agendamentoCliente");
		return mv;
	}
	

	//---------------------------------------- VIEW PARA Barbeiro -------------------------------------
	@GetMapping("/agendamentoBarbeiro")
	public ModelAndView agendamentoBarbeiro() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewBarbeiro/agendamento");
		mv.addObject("agendamento", new Servico());
		mv.addObject("agendamentoList", agendamentoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/excluirAgendamentoBarbeiro/{id}")
	public String excluirBarbeiro(@PathVariable("id") Long id) {
		agendamentoRepositorio.deleteById(id);
		return "redirect:/agendamentoBarbeiro";
	}
}
