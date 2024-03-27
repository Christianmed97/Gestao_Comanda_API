package br.edu.infnet.gestaocomanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.gestaocomanda.model.Produto;
import br.edu.infnet.gestaocomanda.model.Refeicao;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
