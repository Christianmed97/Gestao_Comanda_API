package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Produto;
import br.edu.infnet.gestaocomanda.repository.ProdutoRepository;
import br.edu.infnet.gestaocomanda.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public Produto save(Produto produto) {
		Produto produtoSalvo = produtoRepository.save(produto);
		return produtoSalvo;
	}

	@Override
	public Optional<List<Produto>> findAll() {
		List<Produto> resultado = produtoRepository.findAll();
		return resultado.isEmpty()?Optional.empty():Optional.of(resultado);
	}

	@Override
	public Optional<Produto> findById(int codigo) {
		
		 return produtoRepository.findById(codigo);
	}

	@Override
	public void delete(int codigo) {
		produtoRepository.deleteById(codigo);
		
	}

	@Override
	public Produto update(int codigo, Produto produtoAutalizada) {
		produtoAutalizada.setCodigo(codigo);
		return this.produtoRepository.save(produtoAutalizada);
	}
	



}
