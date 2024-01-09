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
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.api.model.Medico;
import com.example.usuario.api.service.MedicoService;


@RestController
@RequestMapping ("/medico")

public class MedicoController {
	
	@Autowired
	MedicoService medicoService;
	
	@GetMapping
	public List<Medico> listarMedico() {
		return medicoService.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Medico> listarMedicoPorID(@PathVariable Long id) {
		return new ResponseEntity<Medico>(medicoService.listarPorID(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
		return new ResponseEntity<>(medicoService.cadastrarMedico(medico), HttpStatus.CREATED);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deletaMedico(@PathVariable Long id) {
		medicoService.deletarMedico(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Medico> atualizaMedico(@RequestBody Medico medico) {
		return new ResponseEntity<Medico> (medicoService.atualizarMedico(medico), HttpStatus.CREATED);
		
	}

}
