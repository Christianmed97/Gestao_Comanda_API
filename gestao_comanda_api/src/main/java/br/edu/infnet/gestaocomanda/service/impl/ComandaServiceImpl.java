package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.repository.ComandaRepository;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@Service
public class ComandaServiceImpl implements ComandaService {

	private ComandaRepository comandaRepository;
	
	public ComandaServiceImpl(ComandaRepository comandaRepository) {
		this.comandaRepository = comandaRepository;
	}
	

	@Override
	public Comanda salvar(Comanda comanda) {
		Comanda comandaSalva = comandaRepository.save(comanda);
		return comandaSalva;
	}

	@Override
	public Comanda atualizar(Comanda comanda) throws Exception {
		if(comanda.getId()==null) {
			throw new Exception("O cliente não pode ser salvo na base");
		}
		Comanda comandaAtualizada = comandaRepository.save(comanda);
		return comandaAtualizada;
	}

	@Override
	public Optional<List<Comanda>> pesquisarTodos() {
		List<Comanda> resultados = comandaRepository.findAll();
		
		return resultados.isEmpty()
		? Optional.of(resultados)
				: Optional.empty();
	}
	
	@Override
	public Optional<Comanda> pesquisarPorId(Long id) {
		return comandaRepository.findById(id);
	}
	
}
