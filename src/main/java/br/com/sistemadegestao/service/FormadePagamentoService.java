package br.com.sistemadegestao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.FormadePagmento;
import br.com.sistemadegestao.raposytory.FormadePagmantoReposytory;
@Service
public class FormadePagamentoService implements ServiceInterface<FormadePagmento> {
	@Autowired
    private FormadePagmantoReposytory formadepagentorepository;
	@Override
	public FormadePagmento salvar(FormadePagmento objeto) {
	
		return null;
	}

	@Override
	public List<FormadePagmento> pesquisar() {
		
		return formadepagentorepository.findAll();
	}

	@Override
	public FormadePagmento buscarporcodigo(Long id) {

		return formadepagentorepository.findById(id).get();
	}

	@Override
	public List<FormadePagmento> buscar(String parametro) {
	
		return formadepagentorepository.findByNomeformaStartingWith(parametro);
	}

	@Override
	public FormadePagmento pesquisa(String parametro) {
		
		return null;
	}

	@Override
	public void excluir(long codigo) {

		
	}

	@Override
	public boolean isInclusao(FormadePagmento objeto) {
		
		return false;
	}

	@Override
	public boolean isEdicao(FormadePagmento objeto) {

		return false;
	}

}
