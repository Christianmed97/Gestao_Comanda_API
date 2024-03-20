package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.infnet.gestaocomanda.model.Comanda;

public interface ComandaService {

	
	public Comanda salvar (Comanda comanda)throws Exception ;
		
	public Optional<List<Comanda>> pesquisarTodos();
	
	public Comanda atualizar(Comanda comanda)throws Exception;
	
	public Optional<Comanda> pesquisarPorId(Long id);

}
