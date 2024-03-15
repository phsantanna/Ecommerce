package com.project.ecommerce.service;

import com.project.ecommerce.DTO.ProdutosDto;
import com.project.ecommerce.entity.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProdutosService {
    public void criarProduto(ProdutosDto produtosDto);
    public List<Produtos> listarProdutos();
    public Optional<Produtos> buscarPorId(UUID produtoId);
}
