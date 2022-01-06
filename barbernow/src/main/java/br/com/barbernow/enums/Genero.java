package br.com.barbernow.enums;

public enum Genero {
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	NAO_BINARIO("Nao Binario"),
	OUTRO("Outro");
	
	private String genero;
	
	private Genero(String genero) {
		this.genero = genero;
	}
}
