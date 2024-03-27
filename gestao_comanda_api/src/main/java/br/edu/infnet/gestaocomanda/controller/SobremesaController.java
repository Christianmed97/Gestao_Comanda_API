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
import br.edu.infnet.gestaocomanda.model.Sobremesa;
import br.edu.infnet.gestaocomanda.service.SobremesaService;


@Controller
@RequestMapping("/sobremesa")
public class SobremesaController {
	
	@Autowired
	SobremesaService sobremesaService;
	
	@GetMapping("/cadastrar")
	public String sobremesa(Model model,Sobremesa sobremesa) {
		
		model.addAttribute("sobremesa",sobremesa);
		return "sobremesa/frm-sobremesa";
	}
	
	@GetMapping("/procuraSobremesa")
	public String procuraSobremesa(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("sobremesa",model.getAttribute("sobremesaEncontrada"));
		return "sobremesa/procura-sobremesa";
	}
	   
	@PostMapping("/procuraSobremesa")
	public String procuraSobremesa(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Sobremesa> opSobremesa=sobremesaService.pesquisarPorCodigo(codigo);
		try {
			Sobremesa sobremesaEncontrada = opSobremesa.get();
			System.out.println(sobremesaEncontrada);
			attributes.addFlashAttribute("sobremesaEncontrada",sobremesaEncontrada);
		}catch(Exception ex) {
			
		}	
		return "redirect:/sobremesa/procuraSobremesa";
	}
	@PostMapping("/cadastrarSobremesa")
	public String add(Model model,Sobremesa sobremesa,RedirectAttributes redirect) {
		try {
			sobremesaService.salvar(sobremesa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//redirecionar para pagina de erro
		}
		
		return "redirect:../home";
	}
	 
	@GetMapping("/listaSobremesa")
	public String listaSobremesa(Model model,Sobremesa sobremesa) throws ProdutoListarTodosException {
		
		Optional<List<Sobremesa>> opListaSobremesa = sobremesaService.pesquisarTodos();
		try {
			List<Sobremesa> ListaSobremesa = opListaSobremesa.get();
			model.addAttribute("sobremesa",ListaSobremesa);
		}catch(Exception e) {
			return "sobremesa/lista-sobremesa";
		}	
		return "sobremesa/lista-sobremesa";
	}
	
	

}