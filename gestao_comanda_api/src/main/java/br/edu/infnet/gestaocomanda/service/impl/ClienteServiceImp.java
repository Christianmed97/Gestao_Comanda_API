package br.edu.infnet.gestaocomanda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.repository.ClienteRepository;
import br.edu.infnet.gestaocomanda.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {
	
	
	
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImp(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	

	@Override
	public Cliente salvar(Cliente cliente) throws Exception {
		if(cliente.getCpfCnpj().isEmpty()) {
			throw new Exception("O cliente não pode ser salvo na base");
		}
		
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	@Override
	public Cliente atualizar(Cliente cliente) throws Exception {
		if(!cliente.getCpfCnpj().isEmpty()) {
			throw new Exception("O cliente não pode ser salvo na base");
		}
		
		Cliente clienteAtualizado = clienteRepository.save(cliente);
		return clienteAtualizado;
	}

	@Override
	public Cliente desabilitar(String cpfCnpj) throws Exception {
		Optional<Cliente> clienteOptional = clienteRepository.findById(cpfCnpj);
		
		if (!clienteOptional.isPresent()) {
			throw new Exception("Cliente não encontrado");
		}
		
		Cliente clienteEncontrado = clienteOptional.get();
		
		if (clienteEncontrado.isAtivo()) {
			clienteEncontrado.setAtivo(false);
			
			return clienteRepository.save(clienteEncontrado);
				
		} else 	{
			return clienteEncontrado;
		}
	}

	@Override
	public Cliente habilitar(String cpfCnpj) throws Exception {
		Optional<Cliente> clienteOptional = clienteRepository.findById(cpfCnpj);
		
		if (!clienteOptional.isPresent()) {
			throw new Exception("Cliente não encontrado");
		}
		
		Cliente clienteEncontrado = clienteOptional.get();
		
		if (!clienteEncontrado.isAtivo()) {
			clienteEncontrado.setAtivo(true);
			
			return clienteRepository.save(clienteEncontrado);
				
		} else 	{
			return clienteEncontrado;
		}

	}

	@Override
	public Optional<List<Cliente>> pesquisarTodos() {
		List<Cliente> resultados = clienteRepository.findAll();
		
		return resultados.isEmpty()
				? Optional.empty()
						: Optional.of(resultados);
	}

	@Override
	public Optional<Cliente> pesquisarPorCpfCnpj(String cpfCnpj) {
		return clienteRepository.findById(cpfCnpj);
		
	}
}
