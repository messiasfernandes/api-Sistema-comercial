package br.com.sistemadegestao.model;

public class DetalhesErro {
	
	private String titulo;
	private Long status;
	
	private Long timestamp;
	private String mensagemdesevolvedor;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensagemdesevolvedor() {
		return mensagemdesevolvedor;
	}
	public void setMensagemdesevolvedor(String mensagemdesevolvedor) {
		this.mensagemdesevolvedor = mensagemdesevolvedor;
	}
	
	

}
