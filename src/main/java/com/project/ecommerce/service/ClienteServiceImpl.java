package com.project.ecommerce.service;

import com.project.ecommerce.DTO.*;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.enums.Role;
import com.project.ecommerce.exceptions.ClienteJaCadastradoException;
import com.project.ecommerce.exceptions.ClienteNaoEncontradoException;
import com.project.ecommerce.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements ClientesService {
    private final ClientesRepository clientesRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(ClientesRepository clientesRepository, PasswordEncoder passwordEncoder) {
        this.clientesRepository = clientesRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseDto cadastro(CadastroDto cadastroDto) throws NoSuchAlgorithmException {
        if (Objects.nonNull(buscarCliente(cadastroDto.email()))) {
            throw new ClienteJaCadastradoException("Usuário já cadastrado com este e-mail.");
        }

        String senha = cadastroDto.senha();
        if (senha == null) {
            throw new IllegalArgumentException("Senha não pode ser nula.");
        }


        Clientes user = new Clientes(cadastroDto.nome(), cadastroDto.sobrenome(),
                cadastroDto.email(), passwordEncoder.encode(senha));
        user.setRole(Role.USER);

        clientesRepository.save(user);


        return new ResponseDto("success", "Usuário criado com sucesso");
    }


    @Override
    public String login(LoginDto loginDto) {
        Clientes cliente = buscarCliente(loginDto.email());
        if (Objects.isNull(cliente)) {
            throw new ClienteNaoEncontradoException("E-mail ou senha inválidos.");
        }
        boolean senha = BCrypt.checkpw(loginDto.senha(),cliente.getSenha());
        if (!senha) {
            throw new ClienteNaoEncontradoException("Email ou senha inválidos.");
        }
        return "Login realizado!";
    }

    @Override
    public Clientes buscarCliente(String email) {
        return clientesRepository.findByEmail(email);
    }

    @Override
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }

}
