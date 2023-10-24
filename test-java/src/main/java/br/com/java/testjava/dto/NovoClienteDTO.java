package br.com.java.testjava.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;

import br.com.java.testjava.model.Cliente;


public class NovoClienteDTO {
	
	@NotBlank
	private String nomeCliente;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private BigDecimal saldo;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String senha;
	
	

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Cliente toClient() {
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(nomeCliente);
		cliente.setCpf(cpf);
		cliente.setSaldo(saldo);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		return cliente;
	}
	
}
