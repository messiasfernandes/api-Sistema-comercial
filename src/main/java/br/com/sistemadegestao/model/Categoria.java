package br.com.sistemadegestao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
@Entity
@SuppressWarnings("serial")
public class Categoria extends Generica {
	@NotEmpty
	@Column(length = 50, nullable = false, unique = true)
	 private String nomecategoria;

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

}
