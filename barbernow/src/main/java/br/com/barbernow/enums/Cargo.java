package br.com.barbernow.enums;

public enum Cargo {
	ADMINISTRADOR("Administrador"),
	BARBEIRO("Barbeiro"),
	CLIENTE("Cliente");
	
	private String cargo;
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	private Cargo(String cargo) {
		this.cargo = cargo;
	}
}
