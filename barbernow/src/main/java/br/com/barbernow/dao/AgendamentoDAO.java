package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbernow.model.Agendamento;

public interface AgendamentoDAO extends JpaRepository<Agendamento, Long> {

}
