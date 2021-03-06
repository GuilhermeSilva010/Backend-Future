package br.com.drummond.request;

import java.io.Serializable;

public class FundosAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private double valor;
	
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
