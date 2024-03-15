package com.project.ecommerce.DTO;

import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import com.project.ecommerce.entity.Pedidos;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Pedidos}
 */
public record PedidosDto(Clientes clientes, List<ItemCarrinho> produtos){
}