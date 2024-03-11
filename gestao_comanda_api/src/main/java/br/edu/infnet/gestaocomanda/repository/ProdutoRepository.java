package br.edu.infnet.gestaocomanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gestaocomanda.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
