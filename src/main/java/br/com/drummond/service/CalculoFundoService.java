package br.com.drummond.service;

import java.util.List;

import br.com.drummond.model.CalculoFundo;

public interface CalculoFundoService {

	CalculoFundo save(CalculoFundo obj);

	List<CalculoFundo> getListPages(String data,Integer page, Integer rows);
	
	Integer getCount(String data);
	
	CalculoFundo getById(Long id);
	
}
