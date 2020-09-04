package br.com.sistemadegestao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.sistemadegestao.model.Produto;
import br.com.sistemadegestao.raposytory.ProdutoReposytory;
@Service
public class ProdutoService implements ServiceInterface<Produto> {
	@Autowired
     private ProdutoReposytory produtoreposytory;
	@Transactional
	@Override
	public Produto salvar(Produto objeto) {
	
		return produtoreposytory.save(objeto);
	}

	@Override
	public List<Produto> pesquisar() {
	
		return produtoreposytory.findAll();
	}

	@Override
	public Produto buscarporcodigo(Long id) {
	
		return produtoreposytory.findById(id).get();
	}

	@Override
	public List<Produto> buscar(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisa(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInclusao(Produto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEdicao(Produto objeto) {
		// TODO Auto-generated method stub
		return false;
	}
   public List<Produto>buscarmarca( String pnommarca){
	return produtoreposytory.getProdutoWithMarca(pnommarca);
	   
   }
}
