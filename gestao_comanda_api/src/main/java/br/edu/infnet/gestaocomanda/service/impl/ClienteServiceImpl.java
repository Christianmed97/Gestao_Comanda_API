package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.repository.ClienteRepository;
import br.edu.infnet.gestaocomanda.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
			Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	@Override
	public Optional<Cliente> findByCpfCnpj(String cpfCnpj) {
		
		Optional<Cliente> optionalCliente = clienteRepository.findByCpfCnpj(cpfCnpj);
		return  !optionalCliente.isEmpty() 
				? Optional.of(optionalCliente.get()) 
						: Optional.empty();
	}
	
	

}
