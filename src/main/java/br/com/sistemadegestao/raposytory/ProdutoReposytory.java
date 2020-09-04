package br.com.sistemadegestao.raposytory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import br.com.sistemadegestao.model.Produto;
@Repository
public interface ProdutoReposytory extends JpaRepository<Produto, Long> {
	@Query(value =  "SELECT obj FROM  Produto obj  WHERE produto.marca.nomemarca", nativeQuery = true)
	List<Produto> getProdutoWithMarca(@Param("nomemarca") String nomemarca);
}
