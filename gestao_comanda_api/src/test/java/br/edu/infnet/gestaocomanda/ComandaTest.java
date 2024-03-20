package br.edu.infnet.gestaocomanda;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Comanda;
import br.edu.infnet.gestaocomanda.model.TipoCLienteEnum;
import br.edu.infnet.gestaocomanda.model.TipoSexoEnum;
import br.edu.infnet.gestaocomanda.service.ClienteService;
import br.edu.infnet.gestaocomanda.service.ComandaService;

@SpringBootTest
class ComandaTest {
	
	@Autowired
	private ComandaService comandaService ;
	private Comanda comanda;
	@Autowired
	private ClienteService clienteService ;
	private Cliente cliente;
//	@BeforeEach
//	public void setUp() {
//		try {
//			SimpleDateFormat dataPTBR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			
//			comanda.setDataHoraAbertura(dataPTBR.parse("27/02/2024 20:30:00"));
//			comanda.setDataHoraFechamento(dataPTBR.parse("27/02/2024 22:50:00"));
//			comanda.setNumeroMesa(34);
//			
//			Optional<List<Comanda>> optionalDeComandas = this.comandaService.findAll();
//			
//			if (!optionalDeComandas.isEmpty()) {
//				List<Comanda> listaDeComandas = optionalDeComandas.get();
//			
//				assertTrue(listaDeComandas.contains(this.comanda));
//					
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	@Test
	void testaSaveComanda() {
		this.cliente=new Cliente();
		this.comanda = new Comanda();
		cliente.setCpfCnpj("1111121111211");
		cliente.setSexo(TipoSexoEnum.MASCULINO);
		cliente.setTipoCliente(TipoCLienteEnum.PESSOA_FISICA);
		try {
			Cliente clienteSalvo=clienteService.salvar(cliente);
			comanda.setCliente(clienteSalvo);
			comandaService.salvar(comanda);
			Comanda comanda2= comandaService.pesquisarPorId(comanda.getId()).get();
			System.out.println(comanda2);
			assertEquals(TipoSexoEnum.MASCULINO, comanda2.getCliente().getSexo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
		
		
	}
	
	
	

}