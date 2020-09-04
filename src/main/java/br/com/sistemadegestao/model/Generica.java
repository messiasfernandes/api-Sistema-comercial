package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonFormat;



@MappedSuperclass
public class Generica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate datacadastro;
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataaltercao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}

	public LocalDate getDataaltercao() {
		return dataaltercao;
	}

	public void setDataaltercao(LocalDate dataaltercao) {
		this.dataaltercao = dataaltercao;
	}
    @Transient 
	private boolean isInclusao() {

		return getCodigo() == 0l ? true : false;

	}
    @Transient
	private boolean isEdicao() {
		return !isInclusao();
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
		Generica other = (Generica) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
