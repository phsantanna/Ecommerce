package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientesRepository extends JpaRepository<Clientes, UUID> {
    public Clientes findByEmail(String email);
}