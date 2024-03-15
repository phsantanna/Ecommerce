package com.project.ecommerce.repository;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, UUID> {

    CarrinhoCompras findByClientesId(UUID clienteId);

}