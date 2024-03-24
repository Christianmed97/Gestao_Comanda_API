package br.edu.infnet.gestaocomanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.gestaocomanda.model.Funcionario;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/efetuarlogin")
	public String fazerLogin(Model model) {
		Funcionario funcionario = new Funcionario();
		model.addAttribute("funcionario", funcionario);
		
		return "login/login";
	}
	
	@GetMapping("/efetuarlogout")
	public String fazerLogout() {
				
		return "login/login";
	}
}