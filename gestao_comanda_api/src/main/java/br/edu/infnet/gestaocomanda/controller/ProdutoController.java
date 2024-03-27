package br.edu.infnet.gestaocomanda.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.gestaocomanda.exception.ProdutoListarTodosException;
import br.edu.infnet.gestaocomanda.model.Bebida;
import br.edu.infnet.gestaocomanda.model.Produto;
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.model.Sobremesa;
import br.edu.infnet.gestaocomanda.service.BebidaService;
import br.edu.infnet.gestaocomanda.service.ProdutoService;
import br.edu.infnet.gestaocomanda.service.RefeicaoService;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;

	
	@GetMapping("/procuraProduto")
	public String procuraProduto(Model model,RedirectAttributes attributes) {		
		model.addAttribute("produto",model.getAttribute("produtoEncontrado"));
		return "produto/procura-produto";
	} 
	
	@PostMapping("/procuraProduto")
	public String procuraSobremesa(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Produto> opProduto=produtoService.pesquisarPorCodigo(codigo);
		try {
			Produto produtoEncontrado = opProduto.get();
			System.out.println(produtoEncontrado);
			attributes.addFlashAttribute("produtoEncontrado",produtoEncontrado);
		}catch(Exception ex) {
			
		}	
		return "redirect:/produto/procuraProduto";
	}
	@GetMapping("/listaProduto")
	public String listaProduto(Model model) throws ProdutoListarTodosException {
		
		Optional<List<Produto>> opListaProduto = produtoService.pesquisarTodos();
		try {
			List<Produto> ListaProduto = opListaProduto.get();
			model.addAttribute("produto",ListaProduto);
		}catch(Exception e) {
			
		}	
		return "produto/lista-produto";
	}
	
	

}