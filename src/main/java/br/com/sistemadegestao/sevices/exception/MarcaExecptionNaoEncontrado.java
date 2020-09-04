package br.com.sistemadegestao.sevices.exception;

public class MarcaExecptionNaoEncontrado extends RuntimeException {

	
	private static final long serialVersionUID = 4390162785551109025L;

	public MarcaExecptionNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	
	public MarcaExecptionNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	
	}
}
