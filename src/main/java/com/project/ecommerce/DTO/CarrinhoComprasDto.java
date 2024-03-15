package com.project.ecommerce.DTO;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link CarrinhoCompras}
 */
public record CarrinhoComprasDto(Clientes clientes, List<ItemCarrinho> itemCarrinho){
}