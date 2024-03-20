package br.edu.infnet.gestaocomanda.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import br.edu.infnet.gestaocomanda.model.Cliente;


@Controller
public class ClienteController {
	
	public Cliente salvar (Cliente cliente) {
		return null;
	}
	
	public Cliente atualizar(Cliente cliente) {
		return null;
	}
	
	public void desabilitar(String cpfCnpj) {
		
	}
	
	public void habilitar(String cpfCnpj) {
		
	}
	
	private Optional<List<Cliente>> pesquisarTodos() {
		return Optional.empty();
		
	}
	
	private Optional<Cliente> pesquisarPorCpfCnpj(){
		return Optional.empty();
	}
	

}
