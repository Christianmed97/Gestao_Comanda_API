package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;


import br.edu.infnet.gestaocomanda.model.Sobremesa;

public interface SobremesaService {
	
public Sobremesa salvar (Sobremesa sobremesa)throws Exception ;
	
	public Optional<List<Sobremesa>> pesquisarTodos();

}
