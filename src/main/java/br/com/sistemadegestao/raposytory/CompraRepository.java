package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemadegestao.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
