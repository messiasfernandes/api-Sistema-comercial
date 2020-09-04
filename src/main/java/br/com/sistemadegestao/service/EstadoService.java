package br.com.sistemadegestao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.Estado;
import br.com.sistemadegestao.raposytory.EstadoReposytory;
@Service
public class EstadoService implements ServiceInterface<Estado> {

	@Autowired
	private EstadoReposytory estadoReposytory;
	@Override
	public Estado salvar(Estado objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> pesquisar() {
		
		return estadoReposytory.findAll();
	}

	@Override
	public Estado buscarporcodigo(Long id) {
	
		return estadoReposytory.findById(id).get();
	}

	@Override
	public List<Estado> buscar(String parametro) {
	
		return estadoReposytory.findByNomestadoStartingWith(parametro);
	}

	@Override
	public Estado pesquisa(String parametro) {
	
		return null;
	}

	@Override
	public void excluir(long codigo) {
		
		
	}

	@Override
	public boolean isInclusao(Estado objeto) {
		
		return false;
	}

	@Override
	public boolean isEdicao(Estado objeto) {
		
		return false;
	}

}
