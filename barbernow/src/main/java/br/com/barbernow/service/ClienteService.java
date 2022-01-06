package br.com.barbernow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbernow.dao.ClienteDAO;
import br.com.barbernow.exception.ServiceExc;
import br.com.barbernow.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO repositorioCliente;
	
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
	public Cliente loginUser(String login) throws ServiceExc{
		
		Cliente userLogin = repositorioCliente.findByLogin(login);
		//Usuario userSenha = repositorioUsuario.findBySenha(senha);
		
		return userLogin;
	}
	
}
