package br.com.sistemadegestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemadegestao.model.CondicaoPagamento;
import br.com.sistemadegestao.model.Marca;
import br.com.sistemadegestao.raposytory.CondicaoPagamentoRepository;
import br.com.sistemadegestao.sevices.exception.MarcaExecptionNaoEncontrado;
@Service
public class CondicaoPagmentoService implements ServiceInterface<CondicaoPagamento> {
	@Autowired
	   private CondicaoPagamentoRepository condicaorpeository;
	@Override
	public CondicaoPagamento salvar(CondicaoPagamento objeto) {
	
		return null;
	}

	@Override
	public List<CondicaoPagamento> pesquisar() {
		
		return condicaorpeository.findAll();
	}

	@Override
	public CondicaoPagamento buscarporcodigo(Long id) {
		   Optional<CondicaoPagamento>  condicao=condicaorpeository.findById(id);
	          if (condicao.isEmpty()) {
	        	 throw  new MarcaExecptionNaoEncontrado("Marca não encontrada"); 
	          }
			return condicao.get();
	}

	@Override
	public List<CondicaoPagamento> buscar(String parametro) {
	
		return null;
	}

	@Override
	public CondicaoPagamento pesquisa(String parametro) {
	
		return null;
	}

	@Override
	public void excluir(long codigo) {
	
		
	}

	@Override
	public boolean isInclusao(CondicaoPagamento objeto) {

		return false;
	}

	@Override
	public boolean isEdicao(CondicaoPagamento objeto) {
		
		return false;
	}

}
