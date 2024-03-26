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
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.model.Sobremesa;
import br.edu.infnet.gestaocomanda.service.BebidaService;
import br.edu.infnet.gestaocomanda.service.RefeicaoService;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	RefeicaoService refeicaoService;
	@Autowired
	BebidaService bebidaService;
	
	@GetMapping("/cadastrar")
	public String produto(Model model,Refeicao refeicao,Bebida bebida) {
		
		model.addAttribute("refeicao",refeicao);
		model.addAttribute("sobremesa",bebida);
		
		return "produto/frm-produto";
	}
	
	@GetMapping("/procuraProduto")
	public String procuraProduto(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("refeicao",model.getAttribute("refeicaoEncontrada"));
		model.addAttribute("bebida",model.getAttribute("bebidaEncontrada"));
		return "produto/procuraProduto";
	}
	   
	@PostMapping("/procuraRefeicao")
	public String procuraRefeicao(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Refeicao> opRefeicao=refeicaoService.pesquisarPorCodigo(codigo);
		try {
			Refeicao refeicaoEncontrada = opRefeicao.get();
			attributes.addFlashAttribute("refeicaoEncontrada",refeicaoEncontrada);
		}catch(Exception ex) {
			
		}	
		return "redirect:/produto/procuraProduto";
	}
	@PostMapping("/procuraBebidas")
	public String procuraBebidas(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Bebida> opBebida=bebidaService.pesquisarPorCodigo(codigo);
		System.out.println(opBebida);
		try {
			Bebida bebidaEncontrada = opBebida.get();
			System.out.println(bebidaEncontrada);
			attributes.addFlashAttribute("bebidaEncontrada",bebidaEncontrada);
		}catch(Exception ex) {
			
		}	
		return "redirect:/produto/procuraProduto";
	}
	@PostMapping("/cadastrarRefeicao")
	public String add(Model model,Refeicao refeicao,RedirectAttributes redirect) {
		try {
			refeicaoService.salvar(refeicao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//redirecionar para pagina de erro
		}
		
		return "redirect:../home";
	}
	@PostMapping("/cadastrarBebida")
	public String add(Model model,Bebida bebida,RedirectAttributes redirect) {
		
		try {
			bebidaService.salvar(bebida);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//redirecionar para pagina de erro
		}
		
		return "redirect:../home";
	}
	 
	@GetMapping("/listaProduto")
	public String listaProduto(Model model,Refeicao refeicao) throws ProdutoListarTodosException {
		
		Optional<List<Refeicao>> opListaRefeicao = refeicaoService.pesquisarTodos();
		Optional<List<Bebida>> opListaBebida = bebidaService.pesquisarTodos();
		try {
			List<Refeicao> ListaRefeicao = opListaRefeicao.get();
			List<Bebida> ListaBebida = opListaBebida.get();
			model.addAttribute("refeicao",ListaRefeicao);
			model.addAttribute("bebida",ListaBebida);	
		}catch(Exception e) {
			return "redirect:cadastrar";
		}	
		return "produto/lista-produto";
	}
	
	

}