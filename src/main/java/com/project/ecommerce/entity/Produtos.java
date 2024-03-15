package com.project.ecommerce.entity;


import com.project.ecommerce.DTO.ProdutosDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nomeProduto;
    @Column(name = "preco_produto", precision = 10, scale = 2)
    private BigDecimal precoProduto;
    private String imagemProduto;
    private int quantidade;


    // Construtor padrão sem argumentos
    public Produtos(ProdutosDto produtosDto) {
        this.nomeProduto = produtosDto.nomeProduto();
        this.precoProduto = produtosDto.precoProduto();
        this.quantidade = produtosDto.quantidade();
        this.imagemProduto = produtosDto.imagemProduto();
    }

    public Produtos() {

    }

    // Getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
