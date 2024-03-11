package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.gestaocomanda.model.Produto;

public interface ProdutoService {
	
	public Produto save(Produto produto);
	
	public Optional<List<Produto>> findAll();
	
	public Optional<Produto> findById (int id);
	
	public void delete(int codigo);
	
	public Produto update(int id, Produto produtoAutalizada );

}
