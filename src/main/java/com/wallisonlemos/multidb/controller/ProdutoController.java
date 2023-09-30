package com.wallisonlemos.multidb.controller;

import com.wallisonlemos.multidb.model.auth.Usuario;
import com.wallisonlemos.multidb.model.dto.ProdutoCadastroForm;
import com.wallisonlemos.multidb.model.dto.ProdutoDto;
import com.wallisonlemos.multidb.repository.app.ProdutoRepository;
import com.wallisonlemos.multidb.repository.auth.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	public ResponseEntity<ProdutoDto> criar(@Valid @RequestBody ProdutoCadastroForm form) {
		Usuario usuario = this.usuarioRepository
				.findById(form.getUsuarioId())
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

		ProdutoDto produtoDto = new ProdutoDto(repository.save(form.criar(usuario)));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDto);
	}
}
