package br.com.sistemadegestao.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistemadegestao.model.Marca;
import br.com.sistemadegestao.service.MarcaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/marcas")
@Api(value = "Api Rest Marcas")
@CrossOrigin(origins = "*")
public class MarcaResource implements ControllerPadrao<Marca> {
	@Autowired
	MarcaService marcaservice;

	@GetMapping("{codigo}")
	@ApiOperation(value = "Retorna  uma   Marca consultada via id  na lista de Marcas")
	@Override
	public ResponseEntity<Marca> buscapelocodigo(@PathVariable Long codigo) {
		 Marca marca = marcaservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(marca);
	}

	@GetMapping("/por-nome-comecando-com")
	@ApiOperation(value = "Retorna  uma   Marca consultada via parametro na lista de Marcas")
	@Override
	public List<Marca> porNomeComecandoCom(@RequestParam String parametro) {

		return marcaservice.buscar(parametro);
	}

	@DeleteMapping("/{codigo}")
	@ApiOperation(value = "Deleta uma   Marca")
	@Override
	public void excluir(@PathVariable Long codigo) {
		marcaservice.excluir(codigo);

	}

	@PutMapping
	@Override
	@ApiOperation(value = "Atualiza  uma   Marca")
	public ResponseEntity<Marca> editar(@Valid @RequestBody Marca objeto) {

		marcaservice.salvar(objeto);

		return ResponseEntity.ok(objeto);
	}

	@PostMapping
	@Override
	@ApiOperation(value = "Salva  uma   Marca")
	public ResponseEntity<Marca> salvar(@Valid @RequestBody Marca objeto, HttpServletResponse response) {

		Marca marcasalava = marcaservice.salvar(objeto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{codigo}")
				.buildAndExpand(marcasalava.getCodigo()).toUri();
		response.setHeader("LoCation", uri.toASCIIString());

		return ResponseEntity.created(uri).body(marcasalava);
	}

	@GetMapping
	@Override
	@ApiOperation(value = "Retorna uma lista de Marcas")
	public ResponseEntity<List<Marca>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(marcaservice.pesquisar());
	}

}
