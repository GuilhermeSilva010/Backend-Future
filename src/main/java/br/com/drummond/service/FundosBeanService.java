package br.com.drummond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

	
	public List<Fundos> getListPages(String data, Integer page, Integer rows) {
		return repository.getListPages(data, PageRequest.of(page, rows));

	}

	public Integer getCount(String data) {
		return repository.getCount(data);
	}

}
