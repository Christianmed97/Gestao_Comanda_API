package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Comanda;

public interface ClienteService {
	
	public Cliente save(Cliente cliente);
	
	Optional<Cliente> findByCpfCnpj(String cpfCnpj);

}
