package br.com.drummond.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "FUNDOS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Fundos")
public class Fundos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)")
	private String name;

	@Column(nullable = false, columnDefinition = "VARCHAR(255)")
	private double valor;

	@Column(nullable = false, columnDefinition = "VARCHAR(50)")
	private double apliMin;

	@Column(nullable = false, columnDefinition = "VARCHAR(50)")
	private double priceUni;

	@Column(nullable = false, columnDefinition = "VARCHAR(50)")
	private double rentabi;

	@Column(nullable = false, columnDefinition = "VARCHAR(50)")
	private double taxa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
