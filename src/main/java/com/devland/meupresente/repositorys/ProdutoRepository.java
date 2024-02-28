package com.devland.meupresente.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devland.meupresente.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
