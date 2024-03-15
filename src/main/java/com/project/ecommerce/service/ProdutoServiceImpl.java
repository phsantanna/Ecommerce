package com.project.ecommerce.service;

import com.project.ecommerce.DTO.ProdutosDto;
import com.project.ecommerce.entity.Produtos;
import com.project.ecommerce.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutosService{
    private final ProdutosRepository produtosRepository;

    public ProdutoServiceImpl(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @Override
    public void criarProduto(ProdutosDto produtosDto) {
        Produtos produto = new Produtos(produtosDto);
        produtosRepository.save(produto);
    }

    @Override
    public List<Produtos> listarProdutos() {
        return produtosRepository.findAll();
    }

    @Override
    public Optional<Produtos> buscarPorId(UUID produtoId) {
        return produtosRepository.findById(produtoId);
    }
}
