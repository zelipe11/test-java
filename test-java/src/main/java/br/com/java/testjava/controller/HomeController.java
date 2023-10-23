package br.com.java.testjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.java.testjava.model.Empresa;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
