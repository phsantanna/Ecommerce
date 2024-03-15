package com.project.ecommerce.entity;

import com.project.ecommerce.enums.Situacao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes clientes;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> produtos = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ItemCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemCarrinho> produtos) {
        this.produtos = produtos;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

}
