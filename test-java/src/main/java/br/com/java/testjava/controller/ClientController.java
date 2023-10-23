package br.com.java.testjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClientController {
	
	@GetMapping("/client")
	public String client(HttpServletRequest request) {
		request.getAttribute("name");
		return "client";
	}
}
