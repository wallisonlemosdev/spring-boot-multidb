package com.wallisonlemos.multidb.controller;

import com.wallisonlemos.multidb.model.auth.Usuario;
import com.wallisonlemos.multidb.model.dto.UsuarioDto;
import com.wallisonlemos.multidb.repository.auth.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> buscarTodos() {
		List<Usuario> usuarios = repository.findAll();
		List<UsuarioDto> usuarioDtos = UsuarioDto.UsuarioDtoList(usuarios);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioDtos);
	}
}
