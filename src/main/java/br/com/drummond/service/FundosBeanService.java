package br.com.drummond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drummond.model.Fundos;
import br.com.drummond.repository.FundosRepository;

@Service
public class FundosBeanService implements FundosService {

	@Autowired
	FundosRepository repository;

	@Override
	public Fundos save(Fundos obj) {

		return repository.save(obj);
	}

}
