package com.wallisonlemos.multidb.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallisonlemos.multidb.model.auth.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
