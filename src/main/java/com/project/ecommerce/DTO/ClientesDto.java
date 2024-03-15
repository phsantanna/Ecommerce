package com.project.ecommerce.DTO;

import com.project.ecommerce.entity.Clientes;

import java.io.Serializable;

/**
 * DTO for {@link Clientes}
 */
public record ClientesDto(String nome, String sobrenome, String email, String senha){
}