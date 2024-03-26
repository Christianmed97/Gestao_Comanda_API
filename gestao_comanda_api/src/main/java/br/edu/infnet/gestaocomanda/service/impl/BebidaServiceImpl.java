package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.edu.infnet.gestaocomanda.model.Bebida;
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.repository.BebidaRepository;
import br.edu.infnet.gestaocomanda.service.BebidaService;

@Service
public class BebidaServiceImpl implements BebidaService{

	private BebidaRepository bebidaRepository;
	
	public BebidaServiceImpl(BebidaRepository bebidaRepository) {
		this.bebidaRepository = bebidaRepository;
	}
	

	@Override
	public Bebida salvar(Bebida bebida) {
		Bebida bebidaSalva = bebidaRepository.save(bebida);
		return bebidaSalva;
	}



	@Override
	public Optional<List<Bebida>> pesquisarTodos() {
		List<Bebida> resultados = bebidaRepository.findAll();
		
		return resultados.isEmpty()
		? Optional.empty()
				: Optional.of(resultados);
	}
	
	@Override
	public Optional<Bebida> pesquisarPorCodigo(Long codigo) {
		return bebidaRepository.findById(codigo);
		
	}
	

}
