package com.project.ecommerce.repository;

import ch.qos.logback.core.net.server.Client;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, UUID> {
    ItemCarrinho findByClientes(Clientes clientes);
    List<ItemCarrinho> findByClientesId(UUID userId);

}