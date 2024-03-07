package br.edu.infnet.gestaocomanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gestaocomanda.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{

}
