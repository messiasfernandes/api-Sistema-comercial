package br.com.sistemadegestao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.Cidade;

import br.com.sistemadegestao.raposytory.CidadesReposytory;
@Service
public class CidadesService implements ServiceInterface<Cidade> {
	@Autowired
	private CidadesReposytory municipiosreposytorys;

	@Override
	public Cidade salvar(Cidade objeto) {
		
		return null;
	}

	@Override
	public List<Cidade> pesquisar() {
		
		return municipiosreposytorys.findAll();
	}

	@Override
	public Cidade buscarporcodigo(Long id) {
	
		return municipiosreposytorys.findById(id).get();
	}

	@Override
	public List<Cidade> buscar(String parametro) {
	
		return municipiosreposytorys.findByCidadenomeStartingWith(parametro);
	}

	@Override
	public Cidade pesquisa(String parametro) {
		
		return null;
	}

	@Override
	public void excluir(long codigo) {

		
	}

	@Override
	public boolean isInclusao(Cidade objeto) {
	
		return false;
	}

	@Override
	public boolean isEdicao(Cidade objeto) {

		return false;
	}

}
