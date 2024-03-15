package com.project.ecommerce.service;

import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.CustomUserDetails;
import com.project.ecommerce.repository.ClientesRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public final ClientesRepository clientesRepository;

    public UserDetailsServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Clientes cliente = clientesRepository.findByEmail(email);
        if (Objects.isNull(cliente)){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }

        return new CustomUserDetails(cliente);
    }
}
