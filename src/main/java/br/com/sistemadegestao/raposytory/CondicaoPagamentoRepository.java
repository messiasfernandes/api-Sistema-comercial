package br.com.sistemadegestao.raposytory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemadegestao.model.CondicaoPagamento;

public interface CondicaoPagamentoRepository extends JpaRepository<CondicaoPagamento, Long> {

}
