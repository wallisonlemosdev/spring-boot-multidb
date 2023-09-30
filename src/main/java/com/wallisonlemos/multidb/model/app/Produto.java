package com.wallisonlemos.multidb.model.app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Where(clause = "deleted = false")
@SQLDelete(sql = "update produtos set deleted = true, deleted_at = now() where id = ?")
@Getter
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "preco")
	private BigDecimal preco;

	@Column(name = "nome_usuario")
	private String nomeUsuario;

	@Column(name = "bloqueado")
	private boolean bloqueado = false;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	public Produto(String nome, BigDecimal preco, String nomeUsuario) {
		this.nome = nome;
		this.preco = preco;
		this.nomeUsuario = nomeUsuario;
	}
}
