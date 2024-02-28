package br.edu.infnet.gestaocomanda;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@SpringBootTest
class ComandaServiceTest {
	
	@Autowired
	private ComandaService comandaService ;
	private Comanda comanda;
		
	@BeforeEach
	public void setUp() {
		try {
			SimpleDateFormat dataPTBR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			comanda.setDataHoraAbertura(dataPTBR.parse("27/02/2024 20:30:00"));
			comanda.setDataHoraFechamento(dataPTBR.parse("27/02/2024 22:50:00"));
			comanda.setNumeroMesa(34);
			
			Optional<List<Comanda>> optionalDeComandas = this.comandaService.findAll();
			
			if (!optionalDeComandas.isEmpty()) {
				List<Comanda> listaDeComandas = optionalDeComandas.get();
			
				assertTrue(listaDeComandas.contains(this.comanda));
					
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testaSaveComanda() {
			
		this.comanda = new Comanda();
		Optional<List<Comanda>> optionalDeComandas = this.comandaService.findAll();
			
		if (!optionalDeComandas.isEmpty()) {
			List<Comanda> listaDeComandas = optionalDeComandas.get();
		
			assertTrue(listaDeComandas.contains(this.comanda));
				
		} 
		
	}

}
