package br.edu.infnet.gestaocomanda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Comanda;

@Controller
public class ComandaController {
	
	public Comanda salvar (Comanda comanda) {
		return null;
	}
	
	public Comanda atualizar(Comanda comanda) {
		return null;
	}
	
	public void desabilitar(String cpfCnpj) {
		
	}
	
	public void habilitar(String cpfCnpj) {
		
	}
	private Optional<List<Comanda>> pesquisarTodos() {
		return Optional.empty();
		
	}
	private Optional<List<Comanda>> pesquisarPorId() {
		return Optional.empty();
		
	}
	
}
