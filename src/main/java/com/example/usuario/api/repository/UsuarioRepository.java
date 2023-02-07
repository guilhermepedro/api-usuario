package com.example.usuario.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuario.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
