package br.com.sistemadegestao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompraId implements Serializable {

	private static final long serialVersionUID = 2347885641159959166L;
	@Column(name = "codigo_fornecedor")
	private Long idFonecedor;
	@Column(name = "nf_numero")
	private Long Nfnumero;

	public CompraId() {

	}

	public CompraId(Long idFonecedor, Long nfnumero) {
		super();
		this.idFonecedor = idFonecedor;
		Nfnumero = nfnumero;
	}

	public Long getIdFonecedor() {
		return idFonecedor;
	}

	public void setIdFonecedor(Long idFonecedor) {
		this.idFonecedor = idFonecedor;
	}

	public Long getNfnumero() {
		return Nfnumero;
	}

	public void setNfnumero(Long nfnumero) {
		Nfnumero = nfnumero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nfnumero == null) ? 0 : Nfnumero.hashCode());
		result = prime * result + ((idFonecedor == null) ? 0 : idFonecedor.hashCode());
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
		CompraId other = (CompraId) obj;
		if (Nfnumero == null) {
			if (other.Nfnumero != null)
				return false;
		} else if (!Nfnumero.equals(other.Nfnumero))
			return false;
		if (idFonecedor == null) {
			if (other.idFonecedor != null)
				return false;
		} else if (!idFonecedor.equals(other.idFonecedor))
			return false;
		return true;
	}

}
