package br.edu.infnet.gestaocomanda.controller;

import java.util.List;

import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.gestaocomanda.exception.ClienteListarTodosException;
import br.edu.infnet.gestaocomanda.model.Cliente;
import br.edu.infnet.gestaocomanda.service.ClienteService;
import br.edu.infnet.gestaocomanda.service.impl.ClienteServiceImp;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public String cliente(Model model,Cliente cliente) {
		
		model.addAttribute("cliente",cliente);
		
		return "cliente/frm-cliente";
	}
	
	@PostMapping("/cadastrar")
	public String add(Model model,Cliente cliente,RedirectAttributes redirect) {
		
		try {
			clienteService.salvar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//redirecionar para pagina de erro
		}
		
		return "redirect:../home";
	}
	
	@GetMapping("/listaClientes")
	public String listaClientes(Model model,Cliente cliente) throws ClienteListarTodosException {
		
		Optional<List<Cliente>> opListaTodos = clienteService.pesquisarTodos();
		try {
			
			List<Cliente> ListaTodos = opListaTodos.get();
			model.addAttribute("clientes",ListaTodos);
			
		}catch(Exception e) {
			
			//throw new ClienteListarTodosException();
			return "redirect:cadastrar";
		}	
		return "cliente/lista-Cliente";	
	}
	
	

}
