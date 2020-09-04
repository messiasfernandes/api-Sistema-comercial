package br.com.sistemadegestao.service;

import java.util.List;


public interface ServiceInterface<T> {

	public T salvar(T objeto);

	public List<T> pesquisar();

	public T buscarporcodigo(Long id);

	public List<T> buscar(String parametro);

	public T pesquisa(String parametro);

	public void excluir(long codigo);

	public boolean isInclusao(T objeto);

	public boolean isEdicao(T objeto);

}
