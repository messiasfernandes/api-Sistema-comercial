package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.sistemadegestao.model.FormadePagmento;
@Repository
public interface FormadePagmantoReposytory extends JpaRepository<FormadePagmento, Long> {
	
	List<FormadePagmento> findByNomeformaStartingWith(String nomeforma);

}
