package br.com.java.testjava.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import br.com.java.testjava.model.Empresa;


public class NovaEmpresaDTO {
	
	@NotBlank
	private String nomeEmpresa;
	
	@NotBlank
	private String cnpj;
	
	@NotBlank
	private BigDecimal saldo;
	
	private BigDecimal valorPago;
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	public Empresa toEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa(nomeEmpresa);
		empresa.setCnpj(cnpj);
		empresa.setSaldo(saldo);
		empresa.setValorPago(valorPago);
		
		return empresa;
	}
	
}
