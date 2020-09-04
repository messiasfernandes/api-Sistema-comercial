package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;


import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(length = 80)
	private String nomeourazao;
	@NotBlank
	@NotNull
	@Column(length = 11, nullable = false)
	private String celular;
	@Column(length = 10)
	private String telefone;

	@Column(length = 15, nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate datafundacaoouniver;

	private Integer tipopessoa;
	@Email
	@Column(length = 80)
	private String email;
	@Column(length = 120)
	private String siteouredesocial;
	@NotNull
	private Boolean ativo;
	@CNPJ
	/// @CPF
	@Column(length = 14, unique = true)
	private String cpfoucnpj;
	@Embedded
	private Endereco endereco;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeourazao() {
		return nomeourazao;
	}

	public void setNomeourazao(String nomeourazao) {
		this.nomeourazao = nomeourazao;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDatafundacaoouniver() {
		return datafundacaoouniver;
	}

	public void setDatafundacaoouniver(LocalDate datafundacaoouniver) {
		this.datafundacaoouniver = datafundacaoouniver;
	}

	public TipoPessoa getTipopessoa() {
		return TipoPessoa.toEnum(tipopessoa);
	}

	
	public void setTipopessoa(Integer tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiteouredesocial() {
		return siteouredesocial;
	}

	public void setSiteouredesocial(String siteouredesocial) {
		this.siteouredesocial = siteouredesocial;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCpfoucnpj() {
		return cpfoucnpj;
	}

	public void setCpfoucnpj(String cpfoucnpj) {
		this.cpfoucnpj = cpfoucnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
