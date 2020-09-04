package br.com.sistemadegestao.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemadegestao.model.Cidade;
import br.com.sistemadegestao.service.CidadesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/municipios")
@Api(value = "Api Rest Munnicipios")
@CrossOrigin(origins = "*")
public class MunicipiosResource implements ControllerPadrao<Cidade> {
	@Autowired
   private CidadesService municipiosservice;
   @RequestMapping
   @ApiOperation(value = "Retorna  uma   lista de Municipios")
	@Override
	public ResponseEntity<List<Cidade>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body( municipiosservice.pesquisar());
	}

	@Override
	public ResponseEntity<Cidade> salvar(Cidade objeto, HttpServletResponse response) {
	
		return null;
	}
    @RequestMapping("/{codigo}")
    @ApiOperation(value = "Retorna  um Municipio passando id para consultar  lista de Municipios")
	@Override
	public ResponseEntity<Cidade> buscapelocodigo(@PathVariable Long codigo) {
	       Cidade cidade = municipiosservice.buscarporcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}
    @GetMapping("/por-nome-comecando-com")
    @ApiOperation(value = "Retorna  um Municipio passando nome do municipio  para consulta  lista de Municipios")
	@Override
	public List<Cidade> porNomeComecandoCom(@RequestParam String paramettro) {
		
		return municipiosservice.buscar(paramettro);
	}

	@Override
	public void excluir(Long codigo) {
		
		
	}

	@Override
	public ResponseEntity<Cidade> editar(Cidade objeto) {
	
		return null;
	}

}
