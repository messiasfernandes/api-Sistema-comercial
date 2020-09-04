package br.com.sistemadegestao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CondicaoPagamento condicaoPagamento;

	public Fornecedor() {
	condicaoPagamento = new CondicaoPagamento();
	}
  @JsonManagedReference
	public CondicaoPagamento getCondicaoPagamento() {

		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

}
