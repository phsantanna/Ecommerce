package com.project.ecommerce.entity;

import com.project.ecommerce.DTO.ItemCarrinhoDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "itemCarrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produto;
    @ManyToOne
    @JoinColumn(name = "clientes_id", nullable = false)
    private Clientes clientes;
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;
    @ManyToOne
    @JoinColumn(name = "carrinho_compras_id")
    private CarrinhoCompras carrinhoCompras;

    public ItemCarrinho(Clientes clientes, Produtos produtos) {
        this.clientes = clientes;
        this.produto = produtos;
    }

    public ItemCarrinho() {

    }
    public CarrinhoCompras getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(CarrinhoCompras carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

}
