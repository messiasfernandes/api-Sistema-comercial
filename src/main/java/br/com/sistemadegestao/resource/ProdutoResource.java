package br.com.sistemadegestao.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.sistemadegestao.model.Produto;
import br.com.sistemadegestao.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produtos")
@Api(value = "Api Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource implements ControllerPadrao<Produto> {
	@Autowired
	private ProdutoService produtoservice;

	@GetMapping
	@Override
	public ResponseEntity<List<Produto>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(produtoservice.pesquisar());
	}

	@PostMapping
	@ApiOperation(value = "Salva  um   Produto")
	@Override
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto objeto, HttpServletResponse response) {
		Produto produtosalvo = produtoservice.salvar(objeto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{codigo}")
				.buildAndExpand(produtosalvo.getCodigo()).toUri();
		response.setHeader("LoCation", uri.toASCIIString());

		return ResponseEntity.created(uri).body(produtosalvo);
	}

	@RequestMapping("/{codigo}")
	@Override
	public ResponseEntity<Produto> buscapelocodigo(@PathVariable Long codigo) {
		Produto produto = produtoservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}

	@Override
	public List<Produto> porNomeComecandoCom(String paramettro) {
		
		return null;
	}

	@Override
	public void excluir(Long codigo) {
	

	}

	@Override
	public ResponseEntity<Produto> editar(Produto objeto) {
	
		return null;
	}
	
   @RequestMapping("/por-nome-marca")
   public List<Produto>buscamarca(@RequestParam String nomemarca){
	   return produtoservice.buscarmarca(nomemarca);
   }
   
}
