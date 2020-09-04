package br.com.sistemadegestao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.Marca;
import br.com.sistemadegestao.raposytory.MarcaReposytory;
import br.com.sistemadegestao.sevices.exception.MarcaExecptionNaoEncontrado;

@Transactional
@Service
public class MarcaService implements ServiceInterface<Marca> {
	@Autowired
	private MarcaReposytory marcareposytory;

	@Override
	public Marca salvar(Marca objeto) {

		if (objeto.getCodigo() > 0) {
			objeto.setDataaltercao(LocalDate.now());
		}

		return marcareposytory.save(objeto);
	}

	@Override
	public List<Marca> pesquisar() {

		return marcareposytory.findAll();
	}

	@Override
	public Marca buscarporcodigo(Long id) {
    Optional<Marca>  marca=marcareposytory.findById(id);
          if (marca.isEmpty()) {
        	 throw  new MarcaExecptionNaoEncontrado("Marca não encontrada"); 
          }
		return marca.get();
	}

	@Override
	public List<Marca> buscar(String parametro) {

		return marcareposytory.findByNomemarcaStartingWith(parametro);
	}

	@Override
	public Marca pesquisa(String parametro) {

		return null;
	}

	@Override
	public void excluir(long codigo) {
		marcareposytory.deleteById(codigo);

	}

	@Override
	public boolean isInclusao(Marca objeto) {
	
		return false;
	}

	@Override
	public boolean isEdicao(Marca objeto) {
		
		return false;
	}

}
