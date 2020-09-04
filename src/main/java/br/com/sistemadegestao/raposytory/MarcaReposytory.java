package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.Marca;
@Repository
public interface MarcaReposytory extends JpaRepository<Marca, Long> {
	 List<Marca> findByNomemarcaStartingWith(String nomemarca);
}
