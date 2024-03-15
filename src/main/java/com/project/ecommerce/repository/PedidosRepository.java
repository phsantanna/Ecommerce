package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PedidosRepository extends JpaRepository<Pedidos, UUID> {
    List<Pedidos> findByClientesId(UUID id);
}