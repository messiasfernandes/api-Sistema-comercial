package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.ItensCompras;
@Repository
public interface ItemCommpraRepository  extends JpaRepository<ItensCompras, Long>{

}
