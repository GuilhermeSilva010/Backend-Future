package br.com.drummond.service;

import java.util.List;

import br.com.drummond.model.Fundos;

public interface FundosService {

	Fundos save(Fundos obj);

	List<Fundos> getListPages(String data,Integer page, Integer rows);
	
	Integer getCount(String data);
	
	Fundos getById(Long id);
}
