package br.com.drummond.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.drummond.model.Corretora;

@Repository
public interface CorretoraRepository extends JpaRepository<Corretora, Integer> {

	Optional<Corretora> findByNomeLikeIgnoreCase(String nome);

}