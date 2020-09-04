package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemadegestao.model.Fornecedor;
@Repository
public interface FornecedorRepositroy extends JpaRepository<Fornecedor, Long> {

}
