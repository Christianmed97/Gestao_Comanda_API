package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.gestaocomanda.model.Bebida;
import br.edu.infnet.gestaocomanda.model.Refeicao;

public interface BebidaService {

	public Bebida salvar (Bebida bebida)throws Exception ;
	
	public Optional<List<Bebida>> pesquisarTodos();
}
