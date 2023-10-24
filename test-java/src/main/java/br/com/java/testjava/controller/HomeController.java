package br.com.java.testjava.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.java.testjava.model.Empresa;
import br.com.java.testjava.repository.EmpresaRepository;


@Controller
public class HomeController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("Home")
	public String home(Model model) {
		List<Empresa> empresas = empresaRepository.findAll();
		model.addAttribute("empresas", empresas);
		return "Home";
	}
}
