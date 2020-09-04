package br.com.sistemadegestao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContaaPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numtitulo;
	private Long codigofornecedor;

	private Integer numparcela;

	public ContaaPk() {

	}

	public ContaaPk(Integer numtitulo, Long codigofornecedor,Integer numparcela) {
         this.numtitulo= numtitulo;
         this.codigofornecedor= codigofornecedor;
       
         this.numparcela = numparcela;
	}

	public Integer getNumtitulo() {
		return numtitulo;
	}

	public void setNumtitulo(Integer numtitulo) {
		this.numtitulo = numtitulo;
	}

	public Long getCodigofornecedor() {
		return codigofornecedor;
	}

	public void setCodigofornecedor(Long codigofornecedor) {
		this.codigofornecedor = codigofornecedor;
	}



	public Integer getNumparcela() {
		return numparcela;
	}

	public void setNumparcela(Integer numparcela) {
		this.numparcela = numparcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigofornecedor == null) ? 0 : codigofornecedor.hashCode());
		result = prime * result + ((numparcela == null) ? 0 : numparcela.hashCode());
		result = prime * result + ((numtitulo == null) ? 0 : numtitulo.hashCode());
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
		ContaaPk other = (ContaaPk) obj;
		if (codigofornecedor == null) {
			if (other.codigofornecedor != null)
				return false;
		} else if (!codigofornecedor.equals(other.codigofornecedor))
			return false;
		if (numparcela == null) {
			if (other.numparcela != null)
				return false;
		} else if (!numparcela.equals(other.numparcela))
			return false;
		if (numtitulo == null) {
			if (other.numtitulo != null)
				return false;
		} else if (!numtitulo.equals(other.numtitulo))
			return false;
		return true;
	}




	

}
