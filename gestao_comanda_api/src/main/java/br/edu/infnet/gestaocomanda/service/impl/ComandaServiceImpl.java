package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.repository.ComandaRepository;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@Service
public class ComandaServiceImpl implements ComandaService{
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	public ComandaServiceImpl(ComandaRepository comandaRepository) {
		this.comandaRepository = comandaRepository;
		
	}

	@Override
	public Comanda save(Comanda comanda) {
		Comanda comandaSalva = comandaRepository.save(comanda);
		
		return comandaSalva;
		
	}
	
	@Override
	public Optional<List<Comanda>> findAll(){
		List<Comanda> resultado = this.comandaRepository.findAll();
		
		return resultado.isEmpty()
				? Optional.empty()
						: Optional.of(resultado);

	}
	
	@Override
	public Optional<Comanda> findById (Long id){
		return this.comandaRepository.findById(id);
		
	}
	
	public void delete(Long id) {
		this.comandaRepository.deleteById(id);
		
	}
	
	@Override
	public Comanda update(Long id, Comanda comandaAutalizada ) {
		comandaAutalizada.setId(id);
		
		return this.comandaRepository.save(comandaAutalizada);
		
	}

}
