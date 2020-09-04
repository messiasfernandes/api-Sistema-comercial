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
import org.springframework.web.bind.annotation.RestController;


import br.com.sistemadegestao.model.Categoria;

import br.com.sistemadegestao.service.CategoriaService;
@RestController
@RequestMapping("/categorias")
public class CategoriaResouce implements ControllerPadrao<Categoria> {
	@Autowired
	private CategoriaService categoriaservice;
    @GetMapping
	@Override
	public ResponseEntity<List<Categoria>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body( categoriaservice.pesquisar());
	}
    @PostMapping
	@Override
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody  Categoria objeto, HttpServletResponse response) {
		categoriaservice.salvar(objeto);

		return ResponseEntity.ok(objeto);
	}
    @GetMapping("/{codigo}")
	@Override
	public ResponseEntity<Categoria> buscapelocodigo(@PathVariable Long codigo) {
		   Categoria categoria = categoriaservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
    @GetMapping("/por-nome-comecando-com")
    @Override
	public List<Categoria> porNomeComecandoCom(String paramettro) {
		
		return categoriaservice.buscar(paramettro);
	}
	@DeleteMapping("/{codigo}")
	@Override
	public void excluir(Long codigo) {
		categoriaservice.excluir(codigo);
		
	}
    @PutMapping
	@Override
	public ResponseEntity<Categoria> editar( @Validated @RequestBody Categoria objeto) {
		 categoriaservice.salvar(objeto);

	return ResponseEntity.ok(objeto);
	}

}
