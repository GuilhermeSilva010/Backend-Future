package br.com.drummond.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.drummond.model.CalculoFundo;

public interface CalculoFundoRepository extends PagingAndSortingRepository<CalculoFundo, Long> {

	@Query("SELECT o from CalculoFundo o WHERE (:data is null or o.name LIKE CONCAT('%',:data,'%'))")
	List<CalculoFundo> getListPages(@Param("data") String data, Pageable pageable);

	@Query("SELECT COUNT(o) from CalculoFundo o WHERE (:data is null or o.name LIKE CONCAT('%',:data,'%'))")
	Integer getCount(@Param("data") String data);
	
	@Query("SELECT l FROM CalculoFundo l WHERE l.id = :id")
	CalculoFundo getById(@Param("id") Long id);
}
