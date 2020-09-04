package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.Fornecedor;
@RestController
@RequestMapping(name = "/forncedores")
public class ResourceFornecedor implements ControllerPadrao<Fornecedor> {

	@Override
	public ResponseEntity<List<Fornecedor>> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Fornecedor> salvar(Fornecedor objeto, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Fornecedor> buscapelocodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> porNomeComecandoCom(String paramettro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<Fornecedor> editar(Fornecedor objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
