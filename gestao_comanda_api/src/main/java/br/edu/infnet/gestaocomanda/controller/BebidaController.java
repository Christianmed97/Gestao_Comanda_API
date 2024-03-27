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
import br.edu.infnet.gestaocomanda.service.BebidaService;


@Controller
@RequestMapping("/bebida")
public class BebidaController {
	
	@Autowired
	BebidaService bebidaService;
	
	@GetMapping("/cadastrar")
	public String bebida(Model model,Bebida bebida) {
		
		model.addAttribute("bebida",bebida);
		return "bebida/frm-bebida";
	}
	
	@GetMapping("/procuraBebida")
	public String procuraBebida(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("bebida",model.getAttribute("bebidaEncontrada"));
		return "bebida/procura-bebida";
	}
	   
	@PostMapping("/procuraBebida")
	public String procuraBebida(Model model,Long codigo,RedirectAttributes attributes) {
		
		Optional<Bebida> opBebida=bebidaService.pesquisarPorCodigo(codigo);
		try {
			Bebida bebidaEncontrada = opBebida.get();
			attributes.addFlashAttribute("bebidaEncontrada",bebidaEncontrada);
		}catch(Exception ex) {
			
		}	
		return "redirect:/bebida/procuraBebida";
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
	 
	@GetMapping("/listaBebida")
	public String listaBebida(Model model,Bebida bebida) throws ProdutoListarTodosException {
		
		Optional<List<Bebida>> opListaBebida = bebidaService.pesquisarTodos();
		try {
			List<Bebida> ListaBebida = opListaBebida.get();
			model.addAttribute("bebida",ListaBebida);
		}catch(Exception e) {
			return "bebida/lista-bebida";
		}	
		return "bebida/lista-bebida";
	}
	
	

}