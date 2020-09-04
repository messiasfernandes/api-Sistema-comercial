package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.Estado;

@Repository
public interface EstadoReposytory extends JpaRepository<Estado, Long> {
	List<Estado> findByNomestadoStartingWith(String nomestado);
   
}
