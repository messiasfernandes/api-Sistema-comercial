package br.com.sistemadegestao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Pessoa {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private CondicaoPagamento condicao;

	private BigDecimal limitecredito;
	public CondicaoPagamento getCondicao() {
		return condicao;
	}
	public void setCondicao(CondicaoPagamento condicao) {
		this.condicao = condicao;
	}
	public BigDecimal getLimitecredito() {
		return limitecredito;
	}
	public void setLimitecredito(BigDecimal limitecredito) {
		this.limitecredito = limitecredito;
	}
    
}
