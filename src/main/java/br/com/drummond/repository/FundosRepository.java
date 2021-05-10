package br.com.drummond.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.drummond.model.Fundos;

public interface FundosRepository extends PagingAndSortingRepository<Fundos, Long>{

}
