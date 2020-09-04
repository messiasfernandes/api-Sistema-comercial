package br.com.sistemadegestao.model;

public enum TipoProduto {
     Produto("Produto"),
     Serviço("Serviço");
     private String descrico;
     private TipoProduto(String descricao) {
           this.setDescrico(descricao);
	}
	public String getDescrico() {
		return descrico;
	}
	public void setDescrico(String descrico) {
		this.descrico = descrico;
	}
}
