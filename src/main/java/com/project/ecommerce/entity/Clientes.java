package com.project.ecommerce.entity;


import com.project.ecommerce.enums.Role;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    public Clientes(String nome, String sobrenome, String email, String encryptedpassword) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = encryptedpassword;
    }

    public Clientes() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(id, clientes.id) && Objects.equals(nome, clientes.nome) && Objects.equals(sobrenome, clientes.sobrenome) && Objects.equals(email, clientes.email) && Objects.equals(senha, clientes.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, email, senha);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
