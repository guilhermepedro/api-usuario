package com.example.usuario.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.usuario.api.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
