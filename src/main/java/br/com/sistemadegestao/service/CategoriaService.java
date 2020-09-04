package br.com.sistemadegestao.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.Categoria;
import br.com.sistemadegestao.raposytory.CategoriaReposytory;
@Service
public class CategoriaService implements ServiceInterface<Categoria> {
	@Autowired
    private CategoriaReposytory categoriarepository;
	@Override
	public Categoria salvar(Categoria objeto) {
		if (objeto.getCodigo()>0){
			objeto.setDataaltercao(LocalDate.now());
		}
		return categoriarepository.save(objeto);
	}

	@Override
	public List<Categoria> pesquisar() {
		
		return categoriarepository.findAll();
	}

	@Override
	public Categoria buscarporcodigo(Long id) {
          Categoria categoria= categoriarepository.findById(id).get();
		return categoria;
	}

	@Override
	public List<Categoria> buscar(String parametro) {
	
		return categoriarepository.findByNomecategoriaStartingWith(parametro);
	}

	@Override
	public Categoria pesquisa(String parametro) {
	
		return null;
	}

	@Override
	public void excluir(long codigo) {
		categoriarepository.deleteById(codigo);
		
	}

	@Override
	public boolean isInclusao(Categoria objeto) {
	
		return false;
	}

	@Override
	public boolean isEdicao(Categoria objeto) {
	
		return false;
	}

}
