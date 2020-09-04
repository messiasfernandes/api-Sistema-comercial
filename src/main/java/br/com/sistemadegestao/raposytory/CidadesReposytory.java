package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.sistemadegestao.model.Cidade;
@Repository
public interface CidadesReposytory extends JpaRepository<Cidade , Long>{
	List<Cidade> findByCidadenomeStartingWith(String cidadenome);
}
