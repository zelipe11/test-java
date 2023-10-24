package br.com.java.testjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.java.testjava.dto.NovoClienteDTO;
import br.com.java.testjava.model.Cliente;
import br.com.java.testjava.repository.ClientRepository;

@Controller
@RequestMapping("cliente")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("CriarCliente")
	public String CriarCliente() {
		return "cliente/CriarCliente";
	}

	@PostMapping("novo")
	public String novaCliente(@Valid NovoClienteDTO novoClienteDTO, BindingResult result) {
		if (result.hasErrors()) {
			return "Cliente/CriarCliente";
		}

		Cliente cliente = novoClienteDTO.toClient();
		clientRepository.save(cliente);
		return "Cliente/CriarCliente";
	}
}
