package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ContaaPagar implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numtitulo;

	private BigDecimal valoparcela;
	private BigDecimal valoprago;
	private BigDecimal valorapagar;
	@Temporal(TemporalType.DATE)
	private Date datapagemnto;
	@Temporal(TemporalType.DATE)
	private Date datavencimento;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fornecedor fornecedor;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FormadePagmento formadepagamento;
	@Column
	private Integer numerodaparcela;
	
	@Enumerated(EnumType.STRING)
	private StatusConta statusconta;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
    @JoinColumn(nullable = false)
	private Compra compra;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CondicaoPagamento condicaoPagamento;

	public ContaaPagar() {
		this.valoprago = new BigDecimal("0.00");
		this.valorapagar = new BigDecimal("0.00");
	}

	public BigDecimal getValoparcela() {
		return valoparcela;
	}

	public void setValoparcela(BigDecimal valoparcela) {
		this.valoparcela = valoparcela;
	}

	public BigDecimal getValoprago() {
		return valoprago;
	}

	public void setValoprago(BigDecimal valoprago) {
		this.valoprago = valoprago;
	}

	public BigDecimal getValorapagar() {
		return valorapagar;
	}

	public void setValorapagar(BigDecimal valorapagar) {
		this.valorapagar = valorapagar;
	}

	public Date getDatapagemnto() {
		return datapagemnto;
	}

	public void setDatapagemnto(Date datapagemnto) {
		this.datapagemnto = datapagemnto;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getNumerodaparcela() {
		return numerodaparcela;
	}

	public void setNumerodaparcela(Integer numerodaparcela) {
		this.numerodaparcela = numerodaparcela;
	}

	public FormadePagmento getFormadepagamento() {
		return formadepagamento;
	}

	public void setFormadepagamento(FormadePagmento formadepagamento) {
		this.formadepagamento = formadepagamento;
	}

	public StatusConta getStatusconta() {
		return statusconta;
	}

	public void setStatusconta(StatusConta statusconta) {
		this.statusconta = statusconta;
	}

//	public Integer getNumtitulo() {
//		return numtitulo;
//	}
//
//	public void setNumtitulo(Integer numtitulo) {
//		this.numtitulo = numtitulo;
//	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numtitulo == null) ? 0 : numtitulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaaPagar other = (ContaaPagar) obj;
		if (numtitulo == null) {
			if (other.numtitulo != null)
				return false;
		} else if (!numtitulo.equals(other.numtitulo))
			return false;
		return true;
	}
	

}
