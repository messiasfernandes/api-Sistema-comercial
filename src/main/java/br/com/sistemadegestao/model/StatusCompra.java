package br.com.sistemadegestao.model;

public enum StatusCompra {
	Finalazido("FINALZADO"),
    Cancelado("ABERTO"),
    PagoParcial("PAGO PARCIAL");
  private String descrico;
    private StatusCompra(String descricao) {
          this.setDescrico(descricao);
	}
	public String getDescrico() {
		return descrico;
	}
	public void setDescrico(String descrico) {
		this.descrico = descrico;
	}
}
