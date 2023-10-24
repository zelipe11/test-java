package br.com.java.testjava.controller;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/alterarSaldo/{empresaId}")
	public String exibirFormularioAlterarSaldo(@PathVariable Long empresaId, Model model) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);

        if (optionalEmpresa.isPresent()) {
            model.addAttribute("empresa", optionalEmpresa.get());
            return "formulario-alterar-saldo";
        } else {
            return "error404";
        }
    }

    @PostMapping("/alterarSaldo/{empresaId}")
    public String alterarSaldo(@PathVariable Long empresaId, @RequestParam("novoSaldo") BigDecimal novoSaldo) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresaId);

        if (optionalEmpresa.isPresent()) {
            Empresa empresa = optionalEmpresa.get();
            empresa.setSaldo(novoSaldo);
            empresaRepository.save(empresa);

            return "redirect:/Empresa/ListarEmpresas";
        } else {
            return "error404";
        }
    }
}
