package br.com.sistemadegestao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class CondicaoPagamento  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
	@NotNull(message = "o Campo descrição é obrigatório!!")
	@Column(length = 50)
	private String descricao;
///	@Fetch(FetchMode.SUBSELECT)
//	@ElementCollection
//	@CollectionTable(name = "parcela_codicao", joinColumns = @JoinColumn(name = "condicao_parcela"))
//	@AttributeOverrides({ @AttributeOverride(name = "numeroparcela", column = @Column(name = "numparcela")) })

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "condicaopagamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Parcelas> parcelas = new ArrayList<>();

	private Integer qtdeparcelas;

	public String getDescricao() {
		return descricao;
	}

	public Integer getQtdeparcelas() {
		return qtdeparcelas;
	}

	public void setQtdeparcelas(Integer qtdeparcelas) {
		this.qtdeparcelas = qtdeparcelas;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Parcelas> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcelas> parcelas) {
		this.parcelas = parcelas;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		CondicaoPagamento other = (CondicaoPagamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
  
}



