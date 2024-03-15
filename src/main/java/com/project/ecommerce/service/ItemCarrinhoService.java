package com.project.ecommerce.service;

import com.project.ecommerce.DTO.ProdutosDto;
import com.project.ecommerce.entity.ItemCarrinho;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ItemCarrinhoService {

    void addItemAoCarrinho(UUID clienteId, UUID produtoId);
    void adicionarItemExistenteAoCarrinho(UUID clienteId, ItemCarrinho itemCarrinho);
}
