package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.gestaocomanda.model.Pedido;
import br.edu.infnet.gestaocomanda.repository.PedidoRepository;
import br.edu.infnet.gestaocomanda.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public Pedido save(Pedido pedido) {
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		return pedidoSalvo;
	}

	@Override
	public Optional<Pedido> findById(Long id) {
		
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		return  !optionalPedido.isEmpty() 
				? Optional.of(optionalPedido.get()) 
						: Optional.empty();
	}
	
	@Override
	public Optional<List<Pedido>> findAll(){
		List<Pedido> resultado = this.pedidoRepository.findAll();
		
		return resultado.isEmpty()
				? Optional.empty()
						: Optional.of(resultado);

	}
	
	@Override
	public void delete(Long id) {
		pedidoRepository.deleteById(id);
	}
	
	@Override
	public Pedido update(Pedido pedidoAtualizado,Long id) {
		pedidoAtualizado.setId(id);
		return this.pedidoRepository.save(pedidoAtualizado);
}



}