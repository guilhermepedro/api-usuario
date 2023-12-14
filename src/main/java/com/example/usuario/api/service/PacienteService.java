package com.example.usuario.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.usuario.api.exceptionahandler.DataIntegratedViolationException;
import com.example.usuario.api.model.Paciente;
import com.example.usuario.api.repository.PacienteRepository;

@Service

public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List <Paciente> listarTodos() {
		return pacienteRepository.findAll();
	
	}
	
	public Paciente listarPorID(Long id) {
		try {
			Optional<Paciente> paciente = pacienteRepository.findById(id);
			if (paciente.isPresent()) {
				return paciente.get();
			} else {
				throw new DataIntegratedViolationException("Paciente não encontrado");
			}
			
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao encontrar paciente", e);
		}
		
	}

	
	public Paciente cadastrarPaciente(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	public void deletarPaciente(@PathVariable Long id) {
		try {	
			Optional<Paciente> resposta = pacienteRepository.findById(id);
			if (resposta.isPresent()) {
				pacienteRepository.deleteById(id);
			} else {
				throw new DataIntegratedViolationException("Paciente não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao deletar o paciente", e);		
		}
	}
	
	public Paciente atualizarPaciente(@RequestBody Paciente paciente) {
		try {
			Optional<Paciente> resposta = pacienteRepository.findById(paciente.getId());
			if (resposta.isPresent()) {
				return pacienteRepository.save(paciente);
			} else {
				throw new DataIntegratedViolationException("Paciente não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao atualizar o paciente", e);
		}
			
	}
		
}

