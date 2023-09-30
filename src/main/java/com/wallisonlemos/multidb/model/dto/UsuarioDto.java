package com.wallisonlemos.multidb.model.dto;

import com.wallisonlemos.multidb.model.auth.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record UsuarioDto(
        Integer id,
        String nome,
        String email,
        String senha,
        String telefone,
        boolean bloqueado) {

    public UsuarioDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getTelefone(),
                usuario.isBloqueado());
    }

    public static List<UsuarioDto> UsuarioDtoList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }
}
