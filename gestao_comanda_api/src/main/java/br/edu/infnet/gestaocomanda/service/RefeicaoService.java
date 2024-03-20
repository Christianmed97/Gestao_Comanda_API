package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;


import br.edu.infnet.gestaocomanda.model.Refeicao;

public interface RefeicaoService {
	
	public Refeicao salvar (Refeicao refeicao)throws Exception ;
	
	public Optional<List<Refeicao>> pesquisarTodos();



}
