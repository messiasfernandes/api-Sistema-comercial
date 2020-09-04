package br.com.sistemadegestao.model;

public enum StatusConta {
	 Pago("PAGO"),
     Aberto("ABERTO"),
     PagoParcial("PAGO PARCIAL");
   private String descrico;
     private StatusConta(String descricao) {
           this.setDescrico(descricao);
	}
	public String getDescrico() {
		return descrico;
	}
	public void setDescrico(String descrico) {
		this.descrico = descrico;
	}
}
