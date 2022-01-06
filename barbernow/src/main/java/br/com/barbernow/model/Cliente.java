package br.com.barbernow.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario{
	
	@OneToMany
	private Set<Agendamento> agendamentos;

	public Set<Agendamento> getAgendamento() {
		return agendamentos;
	}

	public void setAgendamento(Set<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
}
