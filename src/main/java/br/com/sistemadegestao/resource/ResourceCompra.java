package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.Compra;

import br.com.sistemadegestao.service.CompraService;


@RestController
@RequestMapping("/compras")
public class ResourceCompra implements ControllerPadrao<Compra> {
	@Autowired
	private CompraService compraservice;

	@GetMapping
	@Override
	///@ApiOperation(value = "Retorna uma lista de Compras")
	public ResponseEntity<List<Compra>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(compraservice.pesquisar());
	}

	@Override
	public ResponseEntity<Compra> salvar(Compra objeto, HttpServletResponse response) {
	
		return null;
	}

	@Override
	public ResponseEntity<Compra> buscapelocodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> porNomeComecandoCom(String paramettro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseEntity<Compra> editar(Compra objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
