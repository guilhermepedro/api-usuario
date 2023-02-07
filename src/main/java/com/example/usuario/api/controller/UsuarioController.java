package com.example.usuario.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.api.usuarioDTO;
import com.example.usuario.api.model.Usuario;
import com.example.usuario.api.repository.UsuarioRepository;
import com.example.usuario.api.service.UsuarioService;

@RestController
@RequestMapping ("/usuario")

public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listarUsuario() {
		return usuarioService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public usuarioDTO listarUsuarioPorID(@PathVariable Long id) {
		return usuarioService.listarPorID(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public usuarioDTO cadastrarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.cadastrarUsuario(usuario);
	}
	
	@DeleteMapping ("/{id}")
	public void deletaUsuario(@PathVariable Long id) {
		usuarioService.deletaUsuario(id);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario) {
		return (ResponseEntity<Usuario>) usuarioService.atualizarUsuario(usuario);
		
	}
	


}
