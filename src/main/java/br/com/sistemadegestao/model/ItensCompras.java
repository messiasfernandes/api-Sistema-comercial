package br.com.sistemadegestao.model;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class ItensCompras implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long iditems;
	@JsonIgnore
	@EmbeddedId
	private CompraId id = new CompraId();
	
	public CompraId getId() {
		return id;
	}

	public void setId(CompraId id) {
		this.id = id;
	}
	@ManyToOne ( )
	@JoinColumn(nullable = false )
	private 
	Produto produto;
	@Column(precision = 10, scale = 2)
	private BigDecimal custototal;
	@Column(precision = 10, scale = 3)
	private BigDecimal qtde;

	public ItensCompras() {
		compra = new Compra();
		produto = new Produto();
	}
//	@JsonBackReference
	@ManyToOne
//  @JoinColumns(value = { @JoinColumn(name = "numero_nota", referencedColumnName = "numero_nota", insertable = false, updatable = false),
//	@JoinColumn(name = "nf_numero", referencedColumnName = "Nfnumero",insertable = false, updatable = false),
//	  })
	
	@JoinColumn(nullable = false)
	private Compra compra;
	private BigDecimal subtotal;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public BigDecimal getCustototal() {
		return custototal;
	}

	public void setCustototal(BigDecimal custototal) {
		this.custototal = custototal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItensCompras other = (ItensCompras) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	public Compra getCompra() {
//		return compra;
//	}
//
//	public void setCompra(Compra compra) {
//		this.compra = compra;
//	}

//	public Long getIditems() {
//		return iditems;
//	}
//
//	public void setIditems(Long iditems) {
//		this.iditems = iditems;
//	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((iditems == null) ? 0 : iditems.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ItensCompras other = (ItensCompras) obj;
//		if (iditems == null) {
//			if (other.iditems != null)
//				return false;
//		} else if (!iditems.equals(other.iditems))
//			return false;
//		return true;
//	}





}
