package br.com.barbernow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barbernow.service.ClienteService;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_agendamento")
	private Long id;
	
	private String data;
	
	private String login;
	
	private String hora;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico")
	private Servico servico;
	
	@ManyToOne
	private Cliente cliente;
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getClientes() {
		return cliente;
	}

	public void setClientes(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
