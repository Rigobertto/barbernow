package br.com.barbernow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbernow.model.Administrador;

public interface AdministradorDAO extends JpaRepository<Administrador, Long> {

}
