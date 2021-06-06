package br.com.drummond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.drummond.model.CalculoFundo;
import br.com.drummond.repository.CalculoFundoRepository;

@Service
public class CalculoFundoBeanService implements CalculoFundoService {

	@Autowired
	CalculoFundoRepository repository;

	@Override
	public CalculoFundo save(CalculoFundo obj) {

		return repository.save(obj);
	}

	public List<CalculoFundo> getListPages(String data, Integer page, Integer rows) {
		return repository.getListPages(data, PageRequest.of(page, rows));

	}

	public Integer getCount(String data) {
		return repository.getCount(data);
	}

	@Override
	public CalculoFundo getById(Long id) {
		return repository.getById(id);
	}
	
}
