package com.example.usuario.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.usuario.api.usuarioDTO;
import com.example.usuario.api.model.Usuario;
import com.example.usuario.api.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}
	
	public usuarioDTO listarPorID(Long id) {
		Usuario entity = usuarioRepository.findById(id).get();
		usuarioDTO objDTO = new usuarioDTO(entity);
		return objDTO;	
		
	}
	
	public usuarioDTO cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario entity = usuarioRepository.save(usuario);
		usuarioDTO objDTO = new usuarioDTO(entity);
		return objDTO;
	}
	
	public void deletaUsuario(@PathVariable Long id) {
	usuarioRepository.deleteById(id);
	}
	
	public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {
		
		if (usuario.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização", HttpStatus.NOT_FOUND);
			
		}
		
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}

}
