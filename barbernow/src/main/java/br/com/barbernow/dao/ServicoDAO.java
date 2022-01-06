package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbernow.model.Servico;

public interface ServicoDAO extends JpaRepository<Servico, Long> {

}
