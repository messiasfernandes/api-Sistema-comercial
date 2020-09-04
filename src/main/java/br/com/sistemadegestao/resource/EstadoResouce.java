package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.Estado;
import br.com.sistemadegestao.service.EstadoService;

@RequestMapping("/estados")
@RestController
public class EstadoResouce implements ControllerPadrao<Estado> {
  @Autowired
   private EstadoService estadoservice;
	@GetMapping
	@Override
	public ResponseEntity<List<Estado>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body( estadoservice.pesquisar());
	}

	@Override
	public ResponseEntity<Estado> salvar(Estado objeto, HttpServletResponse response) {
	
		return null;
	}
  @GetMapping("/{codigo}")
	@Override
	public ResponseEntity<Estado> buscapelocodigo(@PathVariable Long codigo) {
		 Estado estado =estadoservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(estado);
	}
     @GetMapping("/por-nome-comecando-com")
	@Override
	public List<Estado> porNomeComecandoCom(@RequestParam String paramettro) {
		
		return estadoservice.buscar(paramettro);
	}

	@Override
	public void excluir(Long codigo) {
		
		
	}

	@Override
	public ResponseEntity<Estado> editar(Estado objeto) {
		
		return null;
	}

}
