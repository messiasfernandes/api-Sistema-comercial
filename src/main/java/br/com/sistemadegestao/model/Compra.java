package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Idcompra;

	@Column(name = "numero_nota",nullable = false)
	private Long numerodaNota;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataCompra;

	private LocalDate datadeentrada;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal totalnota;
	@Column(precision = 10, scale = 2)
	private BigDecimal outradespeszas;
	@Column(precision = 10, scale = 2)
	private BigDecimal seguro;
	@Column(precision = 10, scale = 2)
	private BigDecimal valordofrete;
	private BigDecimal totalproduto;
	private BigDecimal desconto;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fornecedor fornecedor;
	@JsonInclude(value = Include.NON_NULL)
	@Transient
	private Float markqup;
	// @Fetch(FetchMode.SUBSELECT)

    @JsonBackReference
	@OneToMany(mappedBy = "compra",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItensCompras> itemcompras = new ArrayList<>();
	@JsonBackReference
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContaaPagar> contasApagar = new ArrayList<>();

	public Compra() {
		this.valordofrete = BigDecimal.ZERO;
		this.outradespeszas = BigDecimal.ZERO;
		this.seguro = BigDecimal.ZERO;
		this.totalproduto = new BigDecimal("0.00");
		fornecedor = new Fornecedor();

	}

	public Fornecedor getFornecedor() {

		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getTotalnota() {
		return totalnota;
	}

	public void setTotalnota(BigDecimal totalnota) {
		this.totalnota = totalnota;
	}

	public BigDecimal getOutradespeszas() {
		return outradespeszas;
	}

	public void setOutradespeszas(BigDecimal outradespeszas) {
		this.outradespeszas = outradespeszas;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public BigDecimal getValordofrete() {
		return valordofrete;
	}

	public void setValordofrete(BigDecimal valordofrete) {
		this.valordofrete = valordofrete;
	}

	public List<ItensCompras> getItemcompras() {
		return itemcompras;
	}

	public void setItemc(List<ItensCompras> itemcompras) {
		this.itemcompras = itemcompras;
	}

	public List<ContaaPagar> getContasApagar() {
		return contasApagar;
	}

	public void setContasApagar(List<ContaaPagar> contasApagar) {
		this.contasApagar = contasApagar;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public LocalDate getDatadeentrada() {
		return datadeentrada;
	}

	public void setDatadeentrada(LocalDate datadeentrada) {
		this.datadeentrada = datadeentrada;
	}

	public BigDecimal getTotalproduto() {
		return totalproduto;
	}

	public void setTotalproduto(BigDecimal totalproduto) {
		this.totalproduto = totalproduto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Float getMarkqup() {
		return markqup;
	}

	public void setMarkqup(Float markqup) {
		this.markqup = markqup;
	}

//	public List<ContaaPagar> addparcela() {
//		Integer numparcela = 0;
//		for (int pos = 0; pos < fornecedor.getCondicaoPagamento().getParcelas().size(); pos++) {
//			numparcela = numparcela + 1;
//			BigDecimal valorparcela = new BigDecimal(0.00d);
//			BigDecimal percentual = new BigDecimal(0.00d);
//			ContaaPagar contaaPagar = new ContaaPagar();
//			percentual = fornecedor.getCondicaoPagamento().getParcelas().get(pos).getPercentual();
//			percentual = percentual.divide(new BigDecimal(100d));
//		//	contaaPagar.setNumtitulo(numeronota);
//		//	contaaPagar.setCodigofornecedor(fornecedor.getCodigo());
//			contaaPagar.setCompra(this);
//			contaaPagar.setFormadepagamento(
//					fornecedor.getCondicaoPagamento().getParcelas().get(pos).getFormadePagamento());
//			contaaPagar.setCondicaoPagamento(fornecedor.getCondicaoPagamento());
//			contaaPagar.setFornecedor(fornecedor);
//			contaaPagar.setNumerodaparcela(numparcela);
//			contaaPagar.setStatusconta(StatusConta.Aberto);
//			Calendar c = Calendar.getInstance();
//
//			LocalDate data = dataCompra;
//			System.out.println("PRIMEIRA DATA" + data);
//			System.out.println("SEGUNDA DATA" + dataCompra);
//			c.setTime(data);
//			c.add(Calendar.DATE, fornecedor.getCondicaoPagamento().getParcelas().get(pos).getDia());
//			data = c.getTime();
//			contaaPagar.setDatavencimento(data);
//			valorparcela = totalnota.multiply(percentual);
//			contaaPagar.setValoparcela(valorparcela);
//			contaaPagar.setValorapagar(valorparcela);
//			/// contaaPagar.setDataalteraca(new Date());
//			// contaaPagar.setDatacadatro(new Date());
//			contasApagar.add(contaaPagar);
////			dataCompra=data;
//			System.out.println("final" + dataCompra);
//		}
//		return contasApagar;
//	}
//
	public List<ItensCompras> remove(ItensCompras item) {
		int achou = -1;

		for (int posicao = 0; posicao < itemcompras.size() && achou < 0; posicao++) {
			ItensCompras itemtemp = itemcompras.get(posicao);
			if (itemtemp.getProduto().equals(item.getProduto())) {

				achou = posicao;
			}
		}

		if (achou > -1) {
			totalproduto = totalproduto.subtract(itemcompras.get(achou).getSubtotal());
			totalnota = totalnota.subtract(itemcompras.get(achou).getSubtotal());

			itemcompras.remove(achou);
		}
		return itemcompras;
	}

	public void remvoveconta() {
		contasApagar.clear();
	}

	public void setItemcompras(List<ItensCompras> itemcompras) {
		this.itemcompras = itemcompras;
	}

	public Long getNumerodaNota() {
		return numerodaNota;
	}

	public void setNumerodaNota(Long numerodaNota) {
		this.numerodaNota = numerodaNota;
	}

	public Long getIdcompra() {
		return Idcompra;
	}

	public void setIdcompra(Long idcompra) {
		Idcompra = idcompra;
	}

}
