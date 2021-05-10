package br.com.drummond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.drummond.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

}