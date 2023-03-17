package com.example.usuario.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.usuario.api.usuarioDTO;
import com.example.usuario.api.exceptionahandler.DataIntegratedViolationException;
import com.example.usuario.api.model.Usuario;
import com.example.usuario.api.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List <usuarioDTO> listarTodos() {
		List<Usuario> lista = usuarioRepository.findAll();
		List<usuarioDTO> listaDTO = lista.stream().map(obj -> new usuarioDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}
	
	public usuarioDTO listarPorID(Long id) {
		try {
			Optional<Usuario> resposta = usuarioRepository.findById(id);
			if (resposta.isPresent()) {
				Usuario entity = usuarioRepository.findById(id).get();
				usuarioDTO objDTO = new usuarioDTO(entity);
				return objDTO;
			} else {
				throw new DataIntegratedViolationException("Usuário não encontrado");
			}
			
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao deletar o usuário", e);
		}
		
	}

	
	public usuarioDTO cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario entity = usuarioRepository.save(usuario);
		usuarioDTO objDTO = new usuarioDTO(entity);
		return objDTO;
	}
	
	public void deletaUsuario(@PathVariable Long id) {
		try {	
			Optional<Usuario> resposta = usuarioRepository.findById(id);
			if (resposta.isPresent()) {
				usuarioRepository.deleteById(id);
			} else {
				throw new DataIntegratedViolationException("Usuário não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao deletar o usuário", e);		
		}
	}
	
	public usuarioDTO atualizarUsuario(@RequestBody Usuario usuario) {
		try {
			Optional<Usuario> resposta = usuarioRepository.findById(usuario.getId());
			if (resposta.isPresent()) {
				Usuario entity = usuarioRepository.save(usuario);
				usuarioDTO objDTO = new usuarioDTO(entity);
				return objDTO;
			} else {
				throw new DataIntegratedViolationException("Usuário não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao deletar o usuário", e);
		}
			
	}
		
}

