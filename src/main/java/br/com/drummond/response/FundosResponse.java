package br.com.drummond.response;

import java.io.Serializable;

public class FundosResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String valor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
