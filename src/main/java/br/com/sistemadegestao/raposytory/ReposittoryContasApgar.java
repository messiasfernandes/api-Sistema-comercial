package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.ContaaPagar;
@Repository
public interface ReposittoryContasApgar  extends JpaRepository<ContaaPagar, Long>{

}
