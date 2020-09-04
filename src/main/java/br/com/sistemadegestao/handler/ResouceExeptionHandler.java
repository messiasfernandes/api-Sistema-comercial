package br.com.sistemadegestao.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sistemadegestao.model.DetalhesErro;
import br.com.sistemadegestao.sevices.exception.MarcaExecptionNaoEncontrado;

@ControllerAdvice
public class ResouceExeptionHandler {
	@ExceptionHandler(MarcaExecptionNaoEncontrado.class)
   public ResponseEntity<DetalhesErro>handlerExcepitoMarcanaoEncontrada(MarcaExecptionNaoEncontrado e, HttpServletRequest requset){
		
		DetalhesErro detalheerro = new DetalhesErro();
		detalheerro.setTitulo("Marca não encotrada");
		detalheerro.setStatus(404l);
		detalheerro.setMensagemdesevolvedor("http://sistemagestao.com/404");
		detalheerro.setTimestamp(System.currentTimeMillis());
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheerro);
	   
   }
}
