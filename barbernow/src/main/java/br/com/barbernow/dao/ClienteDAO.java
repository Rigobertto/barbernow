package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbernow.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long> {
	public Cliente findByLogin(String login);
	public Cliente findBySenha(String senha);
	
	//public Optional<Cliente> findById(Long id);
}
