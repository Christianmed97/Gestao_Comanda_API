package br.edu.infnet.gestaocomanda.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.gestaocomanda.exception.ProdutoListarTodosException;
import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.service.RefeicaoService;


@Controller
@RequestMapping("/refeicao")
public class RefeicaoController {
	
	@Autowired
	RefeicaoService refeicaoService;
	
	@GetMapping("/cadastrar")
	public String refeicao(Model model,Refeicao refeicao) {
		
		model.addAttribute("refeicao",refeicao);
		return "refeicao/frm-refeicao";
	}
	
	@GetMapping("/procuraRefeicao")
	public String procuraRefeicao(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("refeicao",model.getAttribute("refeicaoEncontrada"));
		return "refeicao/procura-refeicao";
	}
	   
	@PostMapping("/procuraRefeicao")
	public String procuraRefeicao(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Refeicao> opRefeicao=refeicaoService.pesquisarPorCodigo(codigo);
		try {
			Refeicao refeicaoEncontrada = opRefeicao.get();
			attributes.addFlashAttribute("refeicaoEncontrada",refeicaoEncontrada);
		}catch(Exception ex) {
			
		}	
		return "redirect:/refeicao/procuraRefeicao";
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
	 
	@GetMapping("/listaRefeicao")
	public String listaRefeicao(Model model,Refeicao refeicao) throws ProdutoListarTodosException {
		
		Optional<List<Refeicao>> opListaRefeicao = refeicaoService.pesquisarTodos();
		try {
			List<Refeicao> ListaRefeicao = opListaRefeicao.get();
			model.addAttribute("refeicao",ListaRefeicao);
		}catch(Exception e) {
			return "refeicao/lista-refeicao";
		}	
		return "refeicao/lista-refeicao";
	}
	
	@GetMapping("/editarRefeicao/{codigo}")
	public String editarRefeicao(@PathVariable("codigo") Long codigo,Model model) {
		
		Refeicao refeicaoEncontrada = refeicaoService.pesquisarPorCodigo(codigo).get();
		
		model.addAttribute("refeicao",refeicaoEncontrada);
		
		return "refeicao/editar-refeicao";
	}

	@PostMapping("/editarRefeicao")
	public String editarRefeicao(Model model,Refeicao refeicao) {
		
		try{
			refeicaoService.salvar(refeicao);
			return "redirect:/refeicao/procuraRefeicao";
		}catch(Exception e) {
			return "redirect:../home";
		}
	}
	@GetMapping("/deletarRefeicao/{codigo}")
	public String deletarRefeicao(@PathVariable("codigo") Long codigo,Model model) {
		
		try{
			Refeicao refeicaoEncontrada = refeicaoService.pesquisarPorCodigo(codigo).get();
			refeicaoService.deletar(refeicaoEncontrada);
			return "redirect:/refeicao/procuraRefeicao";
		}catch(Exception e) {
			return "redirect:../home";
		}
	}
	
}