package br.com.sistemadegestao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {
	@NotNull
	@NotBlank
	@Column(length = 80)
	private String logradouro;
	private  Integer numero;
	@Column(length = 40)
	private String complento;
	@Column(length = 60)
	private String bairro;
	@Column(length = 9)
	private String cep;
	@NotNull
	@ManyToOne
	@JoinColumn
	private Cidade cidade;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplento() {
		return complento;
	}
	public void setComplento(String complento) {
		this.complento = complento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
