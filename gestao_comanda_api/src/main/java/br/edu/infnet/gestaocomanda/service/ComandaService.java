package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;
import br.edu.infnet.gestaocomanda.model.Comanda;

public interface ComandaService {
		
	public Comanda save(Comanda comanda);
		
	public Optional<List<Comanda>> findAll();
	
	public Optional<Comanda> findById (Long id);
	
	public void delete(Long id);
	
	public Comanda update(Long id, Comanda comandaAutalizada );

	
	

}
