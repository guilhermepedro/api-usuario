package com.example.usuario.api;

import com.example.usuario.api.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class usuarioDTO {
	
	Long id;
	String nome;
	String cpf;
	String email;
	
	public usuarioDTO() {
	}
	
	public usuarioDTO(Long id, String nome, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public usuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
	}
	
	
	

}
