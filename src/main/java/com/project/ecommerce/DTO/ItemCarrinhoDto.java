package com.project.ecommerce.DTO;

import com.project.ecommerce.DTO.CarrinhoComprasDto;
import com.project.ecommerce.DTO.ClientesDto;
import com.project.ecommerce.entity.*;

import java.io.Serializable;

/**
 * DTO for {@link ItemCarrinho}
 */
public record ItemCarrinhoDto(Produtos produto, Clientes clientes){
}