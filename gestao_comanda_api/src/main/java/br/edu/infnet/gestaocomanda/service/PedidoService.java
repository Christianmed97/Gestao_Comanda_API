package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;
import br.edu.infnet.gestaocomanda.model.Pedido;

public interface PedidoService {
	
	public Pedido save(Pedido pedido);
	
	Optional<Pedido> findById(Long id);
	
	Optional<List<Pedido>> findAll();

	public void delete(Long id);
	
	public Pedido update(Pedido pedidoAtualizado,Long id);
	
}
