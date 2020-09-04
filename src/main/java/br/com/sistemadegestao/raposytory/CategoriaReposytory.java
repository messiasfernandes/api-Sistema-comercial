package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.Categoria;
@Repository
public interface CategoriaReposytory extends JpaRepository<Categoria, Long> {
	
    List<Categoria>findByNomecategoriaStartingWith(String nomecategoria);
}
