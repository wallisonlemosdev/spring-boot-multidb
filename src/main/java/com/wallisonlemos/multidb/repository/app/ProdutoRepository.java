package com.wallisonlemos.multidb.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallisonlemos.multidb.model.app.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
