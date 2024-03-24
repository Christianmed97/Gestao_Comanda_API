package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.repository.RefeicaoRepository;
import br.edu.infnet.gestaocomanda.service.RefeicaoService;

@Service
public class RefeicaoServiceImpl implements RefeicaoService{

private RefeicaoRepository refeicaoRepository;
	
	public RefeicaoServiceImpl(RefeicaoRepository refeicaoRepository) {
		this.refeicaoRepository = refeicaoRepository;
	}
	

	@Override
	public Refeicao salvar(Refeicao refeicao) {
		Refeicao refeicaoSalva = refeicaoRepository.save(refeicao);
		return refeicaoSalva;
	}



	@Override
	public Optional<List<Refeicao>> pesquisarTodos() {
		List<Refeicao> resultados = refeicaoRepository.findAll();
		
		return resultados.isEmpty()
		? Optional.of(resultados)
				: Optional.empty();
	}
	

	
	
}
