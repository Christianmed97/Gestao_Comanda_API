package br.edu.infnet.gestaocomanda.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gestaocomanda.model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, UUID> {

	
	
}
