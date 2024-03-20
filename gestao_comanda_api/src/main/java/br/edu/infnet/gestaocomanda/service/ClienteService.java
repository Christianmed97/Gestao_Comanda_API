package br.edu.infnet.gestaocomanda.service;

import java.util.List;
import java.util.Optional;
import br.edu.infnet.gestaocomanda.model.Cliente;


public interface ClienteService {
	
	public Cliente salvar (Cliente cliente)throws Exception ;
	
	public Cliente atualizar(Cliente cliente)throws Exception ;
	
	public Cliente desabilitar(String cpfCnpj)throws Exception ;
	
	public Cliente habilitar(String cpfCnpj)throws Exception ;
	
	public Optional<List<Cliente>> pesquisarTodos();

	public Optional<Cliente> pesquisarPorCpfCnpj(String cpfCopj);

}
