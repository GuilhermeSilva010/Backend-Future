package br.com.drummond.request;

import java.io.Serializable;

public class FundosAddRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
