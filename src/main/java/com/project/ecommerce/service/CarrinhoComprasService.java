package com.project.ecommerce.service;

import com.project.ecommerce.DTO.CarrinhoComprasDto;
import com.project.ecommerce.DTO.ItemCarrinhoDto;
import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import com.project.ecommerce.entity.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CarrinhoComprasService {
    public void adicionarAoCarrinho(UUID carrinhoComprasId, ItemCarrinho itemCarrinho);
    public CarrinhoCompras criarCarrinho(UUID clienteId);
    public CarrinhoCompras verificarCarrinhoExiste(UUID clienteId);

    List<ItemCarrinho> getCarrinhoItemsValidos(UUID clienteId);
}
