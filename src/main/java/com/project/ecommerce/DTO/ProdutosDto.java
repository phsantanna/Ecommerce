package com.project.ecommerce.DTO;

import com.project.ecommerce.entity.Produtos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Produtos}
 */
public record ProdutosDto(String nomeProduto, BigDecimal precoProduto, int quantidade, String imagemProduto){
}