package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projeto Integrado - SystemManagerRentalCar
//  @ File Name : PessoaJuridica.java
//  @ Date : 30/09/2013
//  @ Author : Marcus/Felipe/Reno/David/Phelipe/Orlando
//
//

/** */
public class PessoaJuridica extends Cliente {
	/** */
	private String razaosocial;
	private String nomeFantasia;
	
	public PessoaJuridica()
	{}
	
	public String getRazaosocial() {
		return razaosocial;
	}

	public PessoaJuridica(String razaosocial, String cnpj) {
		super();
		this.razaosocial = razaosocial;
		this.cnpj = cnpj;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/** */
	private String cnpj;

	public String getNomeFantasia() {
		 
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setNomeJuridico(String nome) {
		 
		this.nome = nome;
	}
	
	/** */

}
