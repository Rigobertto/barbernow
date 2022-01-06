package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.barbernow.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	
//	@Query("select j from usuarios j where j.login = :login and j.senha = :senha")
//	public Usuario buscarLogin(String login, String senha);
	
	public Usuario findByLogin(String login);
	public Usuario findBySenha(String senha);
	
}
