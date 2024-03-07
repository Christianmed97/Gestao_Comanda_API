package br.edu.infnet.gestaocomanda;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.gestaocomanda.model.Pedido;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.service.PedidoService;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@SpringBootTest
public class PedidoTest {
	

	@Autowired
	private PedidoService pedidoService;
	private Pedido pedido;
	private Pedido pedido2;
		
	@BeforeEach
	public void setUp() {
		try {
			this.pedido = new Pedido();
			pedido.setObservacao("Observacao test");
			this.pedido2 = new Pedido();
			pedido2.setObservacao("Observacao test2");
			Optional<List<Pedido>> optionalDePedidos = this.pedidoService.findAll();
			
			
			if (!optionalDePedidos.isEmpty()) {
				List<Pedido> listaDePedidos = optionalDePedidos.get();
			
				assertTrue(listaDePedidos.contains(this.pedido));
					
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testaSaveComanda() {
		
		Optional<List<Pedido>> optionalDePedidos = null;
		Pedido pedidoSalvo = pedidoService.save(pedido);
		pedidoService.save(pedido2);
		optionalDePedidos = pedidoService.findAll();
			
		if (!optionalDePedidos.isEmpty()) {
				List<Pedido> listaDePedidos = optionalDePedidos.get();	
	
				assertTrue(listaDePedidos.contains(pedido));
						
					
			} else {
				// verificar depois
			}
		
	}
	
	
	
	@Test
	void testaById() {
		
		pedidoService.save(pedido);
		pedidoService.save(pedido2);
		Pedido pedido3 = pedidoService.findById(1L).get();
		//optionalDePedidos = pedidoService.findAll();
		
		assertEquals(1L, pedido3.getId());
	}
	
	
	@Test
	void testaDelete() {
			
		pedidoService.save(pedido);
		Pedido pedido3 = pedidoService.findById(1L).get();
		assertEquals(1L,pedido3.getId());
		pedidoService.delete(1L);
		Optional<Pedido> pedidodeletado = pedidoService.findById(1L);
		assertTrue(pedidodeletado.isEmpty());
		}
	
	@Test
	void testaUpdate() {
		
		pedidoService.save(pedido);
		pedido.setObservacao("Observacao test3");
		pedidoService.update(pedido, 1L);
		Pedido pedidoatualizado = pedidoService.findById(1L).get();
		assertEquals("Observacao test", pedidoatualizado.getObservacao());
		
	}
		
	}
	


