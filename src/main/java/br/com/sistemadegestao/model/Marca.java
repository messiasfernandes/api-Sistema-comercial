package br.com.sistemadegestao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Marca extends Generica {
	@NotEmpty(message = "O campo marca não pode er em branco !!!")

	@Column(unique = true, length = 50, nullable = false)
	private String nomemarca;

	public String getNomemarca() {
		return nomemarca;
	}

	public void setNomemarca(String nomemarca) {
		this.nomemarca = nomemarca.toUpperCase();
	}

}
