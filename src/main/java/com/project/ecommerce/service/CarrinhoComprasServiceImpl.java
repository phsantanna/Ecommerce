package com.project.ecommerce.service;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import com.project.ecommerce.repository.CarrinhoComprasRepository;
import com.project.ecommerce.repository.ClientesRepository;
import com.project.ecommerce.repository.ItemCarrinhoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarrinhoComprasServiceImpl implements CarrinhoComprasService {
    public final ClientesRepository clientesRepository;
    public final ItemCarrinhoRepository itemCarrinhoRepository;
    public final CarrinhoComprasRepository carrinhoComprasRepository;

    public CarrinhoComprasServiceImpl(ClientesRepository clientesRepository, ItemCarrinhoRepository itemCarrinhoRepository, CarrinhoComprasRepository carrinhoComprasRepository) {
        this.clientesRepository = clientesRepository;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.carrinhoComprasRepository = carrinhoComprasRepository;
    }

    @Override
    public void adicionarAoCarrinho(UUID carrinhoComprasId, ItemCarrinho itemCarrinho) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findById(carrinhoComprasId)
                .orElseThrow(() -> new RuntimeException("ERRO"));
        carrinhoCompras.addAoCarrinho(itemCarrinho);
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    @Override
    public CarrinhoCompras criarCarrinho(UUID clienteId) {
        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        carrinhoCompras.setClientes(cliente);
        carrinhoCompras = carrinhoComprasRepository.save(carrinhoCompras);

        return carrinhoCompras;
    }

    @Override
    public CarrinhoCompras verificarCarrinhoExiste(UUID clienteId) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findByClientesId(clienteId);

        if (carrinhoCompras == null) {
            carrinhoCompras = criarCarrinho(clienteId);
        }

        return carrinhoCompras;
    }

    @Override
    public List<ItemCarrinho> getCarrinhoItemsValidos(UUID clienteId) {
        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByClientesId(clienteId);

        List<ItemCarrinho> itensValidos = new ArrayList<>();
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getPedidos() == null) {
                itensValidos.add(item);
            }
        }

        return itensValidos;
    }



}
