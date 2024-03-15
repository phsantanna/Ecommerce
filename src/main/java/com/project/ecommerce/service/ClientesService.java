package com.project.ecommerce.service;

import com.project.ecommerce.DTO.*;
import com.project.ecommerce.entity.Clientes;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface ClientesService {
    public ResponseDto cadastro(CadastroDto cadastroDto) throws NoSuchAlgorithmException;

    String login(LoginDto loginDto);

    public Clientes buscarCliente(String email);
    public List<Clientes> listarClientes();

}
