package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.model.Sobremesa;
import br.edu.infnet.gestaocomanda.repository.SobremesaRepository;
import br.edu.infnet.gestaocomanda.service.SobremesaService;

@Service
public class SobremesaServiceImpl implements SobremesaService{

private SobremesaRepository sobremesaRepository;
	
	public SobremesaServiceImpl(SobremesaRepository sobremesaRepository) {
		this.sobremesaRepository = sobremesaRepository;
	}
	

	@Override
	public Sobremesa salvar(Sobremesa sobremesa) {
		Sobremesa sobremesaSalva = sobremesaRepository.save(sobremesa);
		return sobremesaSalva;
	}


	@Override
	public Optional<List<Sobremesa>> pesquisarTodos() {
		List<Sobremesa> resultados = sobremesaRepository.findAll();
		
		return resultados.isEmpty()
		? Optional.of(resultados)
				: Optional.empty();
	}
	

	
	
	
}
