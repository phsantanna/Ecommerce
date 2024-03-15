package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutosRepository extends JpaRepository<Produtos, UUID> {
}