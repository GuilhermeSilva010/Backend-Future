package br.com.drummond.response;

import java.io.Serializable;

public class FundosResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	private double valor;
	private double apliMin;
	private double priceUni;
	private double rentabi;
	private double taxa;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getApliMin() {
		return apliMin;
	}

	public void setApliMin(double apliMin) {
		this.apliMin = apliMin;
	}

	public double getPriceUni() {
		return priceUni;
	}

	public void setPriceUni(double priceUni) {
		this.priceUni = priceUni;
	}

	public double getRentabi() {
		return rentabi;
	}

	public void setRentabi(double rentabi) {
		this.rentabi = rentabi;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

}
