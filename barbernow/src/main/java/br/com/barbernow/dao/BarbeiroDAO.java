package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbernow.model.Barbeiro;

public interface BarbeiroDAO extends JpaRepository<Barbeiro, Long> {

}
