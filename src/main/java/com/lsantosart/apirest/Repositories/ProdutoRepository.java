package com.lsantosart.apirest.Repositories;

import com.lsantosart.apirest.Models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);
}
