package br.com.barbernow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbernow.dao.UsuarioDAO;
import br.com.barbernow.exception.ServiceExc;
import br.com.barbernow.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO repositorioUsuario;
	
//	public void salvarUsuario(Usuario user) throws Exception {
//		try {
//			
//			if(repositorioUsuario.findByEmail() != null) {
//				throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
//			}
//			
//			user.setSenha(Util.md5(user.getSenha()));
//		}catch(NoSuchAlgorithmException e) {
//			throw new CriptoExistException("Erro na criptografia da senha");
//		}
//		
//		repositorioUsuario.save(user);
//		
//	}
//	
	public Usuario loginUser(String login) throws ServiceExc{
		
		Usuario userLogin = repositorioUsuario.findByLogin(login);
		//Usuario userSenha = repositorioUsuario.findBySenha(senha);
		
		return userLogin;
	}
	
}
