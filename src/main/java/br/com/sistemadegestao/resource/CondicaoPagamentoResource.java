package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.CondicaoPagamento;
import br.com.sistemadegestao.service.CondicaoPagmentoService;

@RestController
@RequestMapping("/condicoesdepagamentos")
public class CondicaoPagamentoResource implements ControllerPadrao<CondicaoPagamento> {
	
	@Autowired
	   private CondicaoPagmentoService condicoaservice;
     @GetMapping
	@Override
	public ResponseEntity<List<CondicaoPagamento>> listar() {
		
    	 return ResponseEntity.status(HttpStatus.OK).body(condicoaservice.pesquisar());
	}
    @PostMapping
	@Override
	public ResponseEntity<CondicaoPagamento> salvar(@Validated @RequestBody CondicaoPagamento objeto, HttpServletResponse response) {
	
		return null;
	}
    @GetMapping("/{codigo}")
	@Override
	public ResponseEntity<CondicaoPagamento> buscapelocodigo(@PathVariable Long codigo) {
   	     CondicaoPagamento concidcao = condicoaservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(concidcao);
	}
    @GetMapping("/por-nome-comecando-com")
	@Override
	public List<CondicaoPagamento> porNomeComecandoCom(@RequestParam String paramettro) {
		
		return null;
	}
    @DeleteMapping("/{codigo}")
	@Override
	public void excluir(@PathVariable Long codigo) {
		
		
	}
    @PutMapping
	@Override
	public ResponseEntity<CondicaoPagamento> editar(@Valid @RequestBody CondicaoPagamento objeto) {

		return null;
	}

}
