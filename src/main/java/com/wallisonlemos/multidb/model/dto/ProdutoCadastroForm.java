package com.wallisonlemos.multidb.model.dto;

import com.wallisonlemos.multidb.model.app.Produto;
import com.wallisonlemos.multidb.model.auth.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoCadastroForm {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer usuarioId;

    public Produto criar(Usuario usuario) {
        return new Produto(nome, preco, usuario.getNome());
    }
}
