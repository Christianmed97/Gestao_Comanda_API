package br.edu.infnet.gestaocomanda.controller;

import java.util.List;

import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/findCliente")
	public String procuraCliente(Model model,RedirectAttributes attributes) {
		
		model.addAttribute("clientes",model.getAttribute("clientesEncontrados"));
	
		return "cliente/procuraCliente";
	}
	
	@PostMapping("/findCliente")
	public String procuraCliente(Model model,Cliente cliente,String cpfCnpj,RedirectAttributes attributes) {
		
		Optional<Cliente> opCliente = clienteService.pesquisarPorCpfCnpj(cpfCnpj);
		
		try {
			Cliente found = opCliente.get();
			attributes.addFlashAttribute("clientesEncontrados",found);
			
		}catch(Exception ex) {
			
		}	
		return "redirect:/cliente/findCliente";
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
	
	
	@GetMapping("/editarCliente/{cpfCnpj}")
	public String editarCliente(@PathVariable("cpfCnpj") String cpfCnpj,Model model,Cliente cliente) {
		
		Cliente clienteFound = clienteService.pesquisarPorCpfCnpj(cpfCnpj).get();
		
		model.addAttribute("cliente",clienteFound);
		
		return "cliente/editarCliente";
	}
	
	@PostMapping("/editarCliente")
	public String editarCliente(Model model,Cliente cliente) {
		
		try{
			clienteService.salvar(cliente);
			return "redirect:/cliente/findCliente";
		}catch(Exception e) {
			return "redirect:../home";
		}
	
		
		
	}
	
	

}
