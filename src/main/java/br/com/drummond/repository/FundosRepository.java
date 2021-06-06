package br.com.drummond.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.drummond.model.Fundos;

public interface FundosRepository extends JpaRepository<Fundos, Long> {

	@Query("SELECT o from Fundos o WHERE (:data is null or o.name LIKE CONCAT('%',:data,'%'))")
	List<Fundos> getListPages(@Param("data") String data, Pageable pageable);

	@Query("SELECT COUNT(o) from Fundos o WHERE (:data is null or o.name LIKE CONCAT('%',:data,'%'))")
	Integer getCount(@Param("data") String data);
	
	@Query("SELECT l FROM Fundos l WHERE l.id = :id")
	Fundos getById(@Param("id") Long id);
	
	
}
