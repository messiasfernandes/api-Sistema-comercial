package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;


public  interface ControllerPadrao<T> {
	public ResponseEntity<List<T>> listar();
	public ResponseEntity<T> salvar(T objeto,HttpServletResponse response);
	public ResponseEntity<T> buscapelocodigo( Long codigo) ;
    public List<T> porNomeComecandoCom(String paramettro) ;
	public void excluir( Long codigo);
	public ResponseEntity<T> editar(T objeto );

		
	
   
}
