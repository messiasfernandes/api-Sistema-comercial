package br.com.sistemadegestao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
public class FormadePagmento extends Generica {
	@Column(nullable = false, length = 50, unique = true)
     private String nomeforma;

	public String getNomeforma() {
		return nomeforma;
	}

	public void setNomeforma(String nomeforma) {
		this.nomeforma = nomeforma;
	}
	
}
