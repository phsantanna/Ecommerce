package com.project.ecommerce.entity;

import com.project.ecommerce.DTO.CarrinhoComprasDto;
import com.project.ecommerce.DTO.ItemCarrinhoDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carrinhoDeCompras")
public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "clientes_id", nullable = false, unique = true)
    private Clientes clientes;
    @OneToMany(mappedBy = "carrinhoCompras", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemCarrinho> itemCarrinho = new ArrayList<>();

    public CarrinhoCompras() {

    }
    public void addAoCarrinho(ItemCarrinho itemsCarrinho){
        itemCarrinho.add(itemsCarrinho);
        itemsCarrinho.setCarrinhoCompras(this);
    }

    public CarrinhoCompras(CarrinhoComprasDto carrinhoComprasDto) {
        this.clientes = carrinhoComprasDto.clientes();
        this.itemCarrinho = carrinhoComprasDto.itemCarrinho();
    }

    public List<ItemCarrinho> getItemCarrinho() {
        return itemCarrinho;
    }

    public void setItemCarrinho(List<ItemCarrinho> itemCarrinho) {
        this.itemCarrinho = itemCarrinho;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

}
