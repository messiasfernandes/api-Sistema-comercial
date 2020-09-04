package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
