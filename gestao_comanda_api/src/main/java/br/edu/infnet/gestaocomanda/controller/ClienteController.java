package br.edu.infnet.gestaocomanda.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.gestaocomanda.model.Cliente;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("/cadastrar")
	public String cliente() {
		return "cliente/frm-cliente";
	}
	
	

}
