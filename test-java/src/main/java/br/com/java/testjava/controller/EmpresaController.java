package br.com.java.testjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.java.testjava.dto.NovaEmpresaDTO;
import br.com.java.testjava.model.Empresa;
import br.com.java.testjava.repository.EmpresaRepository;

@Controller
@RequestMapping("Empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("CriarEmpresa")
	public String CriarEmpresa() {
		return "Empresa/CriarEmpresa";
	}

	@PostMapping("nova")
	public String novaEmpresa(@Valid NovaEmpresaDTO novaEmpresaDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "Empresa/CriarEmpresa";
		}

		Empresa empresa = novaEmpresaDTO.toEmpresa();
		empresaRepository.save(empresa);
		return "Empresa/CriarEmpresa";
	}
}
