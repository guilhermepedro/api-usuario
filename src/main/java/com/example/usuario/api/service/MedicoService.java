package com.example.usuario.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.usuario.api.exceptionahandler.DataIntegratedViolationException;
import com.example.usuario.api.model.Medico;
import com.example.usuario.api.repository.MedicoRepository;

@Service

public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public List <Medico> listarTodos() {
		return medicoRepository.findAll();
	}
	
	public Medico listarPorID(Long id) {
		try {
			Optional<Medico> medico = medicoRepository.findById(id);
			if (medico.isPresent()) {
				return medico.get();
			} else {
				throw new DataIntegratedViolationException("Médico não encontrado");
			}
			
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao encontrar médico", e);
		}
		
	}
	
	public Medico cadastrarMedico(@RequestBody Medico medico) {
		return medicoRepository.save(medico);
	}
	
	public void deletarMedico(@PathVariable Long id) {
		try {	
			Optional<Medico> medico = medicoRepository.findById(id);
			if (medico.isPresent()) {
				medicoRepository.deleteById(id);
			} else {
				throw new DataIntegratedViolationException("Médico não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao deletar o médico", e);		
		}
	}
	
	public Medico atualizarMedico(@RequestBody Medico medico) {
		try {
			Optional<Medico> resposta = medicoRepository.findById(medico.getId());
			if (resposta.isPresent()) {
				return medicoRepository.save(medico);
			} else {
				throw new DataIntegratedViolationException("Médico não encontrado");
			}
		} catch (Exception e) {
			throw new DataIntegratedViolationException("Falha ao atualizar o médico", e);
		}
			
	}

}
