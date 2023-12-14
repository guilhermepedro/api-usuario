package com.example.usuario.api.controller;

import java.util.List;
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

import com.example.usuario.api.model.Paciente;
import com.example.usuario.api.service.PacienteService;

@RestController
@RequestMapping ("/paciente")

public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping
	public List<Paciente> listarPaciente() {
		return pacienteService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Paciente> listarPacientePorID(@PathVariable Long id) {
		return new ResponseEntity<Paciente>(pacienteService.listarPorID(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
		return new ResponseEntity<>(pacienteService.cadastrarPaciente(paciente), HttpStatus.CREATED);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deletaPaciente(@PathVariable Long id) {
		pacienteService.deletarPaciente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Paciente> atualizaUsuario(@RequestBody Paciente paciente) {
		return new ResponseEntity<Paciente> (pacienteService.atualizarPaciente(paciente), HttpStatus.CREATED);
		
	}
	


}
