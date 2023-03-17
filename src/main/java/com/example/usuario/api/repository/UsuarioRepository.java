package com.example.usuario.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.usuario.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}
