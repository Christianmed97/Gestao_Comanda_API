package br.edu.infnet.gestaocomanda;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.service.ClienteService;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@SpringBootTest
public class ClienteTest {
	

	@Autowired
	private ClienteService clienteService;
	
	
	@Test
	void testaSaveCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setCpfCnpj("111111111");
		cliente.setNome("Pedro");
		cliente.setEmail("pedro@email.com");
		
		clienteService.save(cliente);
		Optional<Cliente> clienteTest = clienteService.findByCpfCnpj("121111111");
		
		System.out.println(clienteTest);	
		if(clienteTest.isEmpty()) {
		
			assertEquals(clienteTest.get(), cliente);
		
		}else {
			
		}
		
		
		
	}
	

}
