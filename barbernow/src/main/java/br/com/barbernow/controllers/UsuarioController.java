package br.com.barbernow.controllers;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.barbernow.dao.UsuarioDAO;
import br.com.barbernow.enums.Cargo;
import br.com.barbernow.exception.ServiceExc;
import br.com.barbernow.model.Usuario;
import br.com.barbernow.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioDAO usuarioRepositorio;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuarioLogado;
	
	//
	//
	
	ServicoController servico;
	Cargo cargo;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("Login/login");
		return mv;
	}
	
	@GetMapping("/dados")
	public ModelAndView dados() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", this.usuarioLogado);
		mv.setViewName("Login/dados");
		return mv;
	}
	
	@GetMapping("/dadosADM")
	public ModelAndView dadosADM() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.addObject("dados", this.usuarioLogado);
		return mv;
	}
	
//	@GetMapping("/cadastro")
//	public ModelAndView cadastro() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("usuario", new Usuario());
//		mv.setViewName("Login/cadastro");
//		return mv;
//	}
		
	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		usuarioRepositorio.save(usuario);
		return mv;
	}
	
	@PostMapping("autenticar")
	public ModelAndView autenticarUsuario(@Valid Usuario usuario, BindingResult result) throws ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		Usuario userLogin = usuarioService.loginUser(usuario.getLogin());
		
		if(userLogin == null) {
			mv.addObject("msg", "Úsuario ou senha incorreto. Tente novamente!");
			mv.setViewName("Login/login");
		}else if(userLogin.getSenha().equals(usuario.getSenha())) {
			if(userLogin.getCargo() == Cargo.ADMINISTRADOR) {
				this.usuarioLogado = userLogin;
				mv.setViewName("Agendamento/agendamento");
				
			}else if(userLogin.getCargo() == Cargo.CLIENTE) {
				this.usuarioLogado = userLogin;
				//usua.setUsuarioLogado(userLogin);
				mv.setViewName("ViewCliente/agendamento");
			}else if(userLogin.getCargo() == Cargo.BARBEIRO){
				this.usuarioLogado = userLogin;
				mv.setViewName("ViewBarbeiro/agendamento");
			}
		}else{
			mv.setViewName("Login/login");
		}
		
		return mv;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	//------------------------- VIEW CLIENTE ---------------------------------
	@GetMapping("/dadosCliente")
	public ModelAndView dadosCliente() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", this.usuarioLogado);
		mv.setViewName("ViewCliente/dados");
		return mv;
	}
	
	//------------------------- VIEW BARBEIRO ---------------------------------
	@GetMapping("/dadosBarbeiro")
	public ModelAndView dadosBarbeiro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", this.usuarioLogado);
		mv.setViewName("ViewBarbeiro/dados");
		return mv;
	}
		
}
