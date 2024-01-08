package com.example.usuario.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuario.api.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
