package br.com.sistemadegestao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.Compra;
import br.com.sistemadegestao.raposytory.CompraRepository;
@Service
public class CompraService implements ServiceInterface<Compra> {
	
	@Autowired
  private CompraRepository comprarepository;
	@Override
	public Compra salvar(Compra objeto) {
	
		return comprarepository.save(objeto);
	}

	@Override
	public List<Compra> pesquisar() {

		return comprarepository.findAll();
	
	}
	@Override
	public Compra buscarporcodigo(Long id) {
		
		return null;
	}

	@Override
	public List<Compra> buscar(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra pesquisa(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInclusao(Compra objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEdicao(Compra objeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
