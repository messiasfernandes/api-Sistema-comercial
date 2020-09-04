package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.FormadePagmento;
import br.com.sistemadegestao.service.FormadePagamentoService;
@RestController
@RequestMapping("/formadepagamento")
public class FormadePagamentoResource implements ControllerPadrao<FormadePagmento> {
	@Autowired
    private FormadePagamentoService formadepagamentoservcie;
    @GetMapping
	@Override
	public ResponseEntity<List<FormadePagmento>> listar() {
	
		return ResponseEntity.status(HttpStatus.OK).body(formadepagamentoservcie.pesquisar());
	}

	@Override
	public ResponseEntity<FormadePagmento> salvar(FormadePagmento objeto, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FormadePagmento> buscapelocodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormadePagmento> porNomeComecandoCom(String paramettro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<FormadePagmento> editar(FormadePagmento objeto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
