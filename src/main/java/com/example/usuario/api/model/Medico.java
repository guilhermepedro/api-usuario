package com.example.usuario.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String numeroCRM;
	String pacientes;
	String endereco;
	String especializacao;
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNumeroCRM() {
		return numeroCRM;
	}


	public void setNumeroCRM(String numeroCRM) {
		this.numeroCRM = numeroCRM;
	}


	public String getPacientes() {
		return pacientes;
	}


	public void setPacientes(String pacientes) {
		this.pacientes = pacientes;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getEspecializacao() {
		return especializacao;
	}


	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

}
