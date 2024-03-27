package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Produto;
import br.edu.infnet.gestaocomanda.model.Refeicao;


public interface ProdutoService {
	
	public Optional<List<Produto>> pesquisarTodos();
	

	public Optional<Produto> pesquisarPorCodigo(Long codigo);

}
