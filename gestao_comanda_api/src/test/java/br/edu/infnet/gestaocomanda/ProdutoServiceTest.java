package br.edu.infnet.gestaocomanda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.gestaocomanda.model.Produto;
import br.edu.infnet.gestaocomanda.service.ProdutoService;
import lombok.Builder;

@SpringBootTest
public class ProdutoServiceTest {
	
	@Autowired
	ProdutoService produtoService;
	
	
	@BeforeEach
	public void init() {
			
		Produto produto1 = Produto.builder().nome("Macarrão").valor(10.5f).build();
		produtoService.save(produto1);
		Produto produto2 = Produto.builder().nome("Chocolate").valor(5.8f).build();
		produtoService.save(produto2);
			
	}
	
	@Test
	@DisplayName("Teste do FindAll")
	public void testeFindAll() {
		
		Optional<List<Produto>>	listaProdutos = produtoService.findAll();
		if(!listaProdutos.isEmpty()) {
			
			//assertEquals(1, listaProdutos.get().size());
			assertEquals(2, listaProdutos.get().size());
		}	
	}
	
	@Test
	@DisplayName("Teste FindById")
	public void testeFindById() {
		
		Optional<Produto> produtoAchado = produtoService.findById(1);
		Produto produtoTesteChocolte = produtoService.findById(2).get();
		
		if(produtoAchado.isPresent()) {
			
			assertEquals("Macarrão",produtoAchado.get().getNome());
			//assertEquals("Macarrão",produtoTesteChocolte.getNome());
			
		}
	}
	
	@Test
	@DisplayName("Testa deleteById")
	public void testeDeleteById() {
		
		Optional<List<Produto>>	listaProdutos = produtoService.findAll();
	
		if(!listaProdutos.isEmpty()) {
			
			assertEquals(2,listaProdutos.get().size());
			Optional<Produto> optProdutoTeste = produtoService.findById(1);
			
			if(optProdutoTeste.isPresent()) {
				
				produtoService.delete(1);
				listaProdutos = produtoService.findAll();
				assertEquals(1,listaProdutos.get().size());
				optProdutoTeste = produtoService.findById(1);
				assertTrue(optProdutoTeste.isEmpty());
				//assertTrue(optProdutoTeste.isPresent());
			}	
		}
	}
	
	@Test
	@DisplayName("Testa update")
	public void testaUpdateById() {
		
		Optional<List<Produto>>	listaProdutos = produtoService.findAll();
		Optional<Produto> testeProduto = produtoService.findById(1);
		
		assertEquals(2, listaProdutos.get().size());
		if(testeProduto.isPresent()) {
			
			Produto produtoTeste = testeProduto.get();
			produtoTeste.setNome("Sorvete");
			produtoService.update(1, produtoTeste);
			listaProdutos = produtoService.findAll();
			assertEquals(2, listaProdutos.get().size());
			produtoTeste = produtoService.findById(1).get();
			assertEquals("Sorvete",produtoTeste.getNome());
			//assertEquals("Macarrão",produtoTeste.getNome());	
		}
		
	}
	

}
