package com.wallisonlemos.multidb.model.dto;

import com.wallisonlemos.multidb.model.app.Produto;

import java.math.BigDecimal;

public record ProdutoDto(
        Integer id,
        String nome,
        BigDecimal preco,
        String nomeUsuario,
        boolean bloqueado) {

    public ProdutoDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getNomeUsuario(),
                produto.isBloqueado());
    }
}
