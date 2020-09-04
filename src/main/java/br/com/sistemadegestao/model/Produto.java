package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.bytebuddy.asm.Advice.This;
@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nomeroduto;
	private BigDecimal precovenda;
	private BigDecimal qte;
    private BigDecimal custo;
    private Boolean ativo;
    private BigDecimal precoultimacompa;
    private LocalDate dataultimacompra;
    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Marca marca;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;
	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItensCompras> items = new ArrayList<>();
    public Produto() {
	     this.qte= BigDecimal.ZERO;
	     this.precovenda=BigDecimal.ZERO;
	     this.precoultimacompa=BigDecimal.ZERO;
	}
	public BigDecimal getPrecoultimacompa() {
		return precoultimacompa;
	}
	public void setPrecoultimacompa(BigDecimal precoultimacompa) {
		this.precoultimacompa = precoultimacompa;
	}
	public LocalDate getDataultimacompra() {
		return dataultimacompra;
	}
	public void setDataultimacompra(LocalDate dataultimacompra) {
		this.dataultimacompra = dataultimacompra;
	}
	public TipoProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNomeroduto() {
		return nomeroduto;
	}
	public void setNomeroduto(String nomeroduto) {
		this.nomeroduto = nomeroduto;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public BigDecimal getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda;
	}
	public BigDecimal getQte() {
		return qte;
	}
	public void setQte(BigDecimal qte) {
		this.qte = qte;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public List<ItensCompras> getItems() {
		return items;
	}
	public void setItems(List<ItensCompras> items) {
		this.items = items;
	}
	
}
