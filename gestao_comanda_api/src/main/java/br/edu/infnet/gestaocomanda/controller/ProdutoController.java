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
import br.edu.infnet.gestaocomanda.model.Refeicao;
import br.edu.infnet.gestaocomanda.service.RefeicaoService;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	RefeicaoService refeicaoService;
	
	@GetMapping("/cadastrar")
	public String refeicao(Model model,Refeicao refeicao) {
		
		model.addAttribute("refeicao",refeicao);
		
		return "produto/frm-produto";
	}
	
	@GetMapping("/procuraProduto")
	public String procuraRefeicao(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("refeicao",model.getAttribute("refeicaoEncontrada"));
	
		return "produto/procuraProduto";
	}
	   
	@PostMapping("/procuraProduto")
	public String procuraRefeicao(Model model,Refeicao refeicao,Long codigo,RedirectAttributes attributes) {
		
		Optional<Refeicao> opRefeicao=refeicaoService.pesquisarPorCodigo(codigo);
		
		try {
			Refeicao refeicaoEncontrada = opRefeicao.get();
			attributes.addFlashAttribute("refeicaoEncontrada",refeicaoEncontrada);
			
		}catch(Exception ex) {
			
		}	
		return "redirect:/produto/procuraProduto";
	}

	@PostMapping("/cadastrar")
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
	 
	@GetMapping("/listaProduto")
	public String listaRefeicao(Model model,Refeicao refeicao) throws ProdutoListarTodosException {
		
		Optional<List<Refeicao>> opListaTodos = refeicaoService.pesquisarTodos();
		System.out.println(opListaTodos);
		try {
			
			List<Refeicao> ListaTodos = opListaTodos.get();
			System.out.println(ListaTodos);
			model.addAttribute("refeicao",ListaTodos);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:cadastrar";
		}	
		return "produto/lista-produto";
	}
	
	

}