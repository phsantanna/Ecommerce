package com.project.ecommerce.service;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Pedidos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PedidosService {
    public Pedidos criarPedido(UUID clienteId);
    List<Pedidos> getAllPedidosByCliente(UUID id);
}
