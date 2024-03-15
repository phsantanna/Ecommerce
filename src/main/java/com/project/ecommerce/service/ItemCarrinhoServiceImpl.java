package com.project.ecommerce.service;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import com.project.ecommerce.entity.Produtos;
import com.project.ecommerce.repository.ClientesRepository;
import com.project.ecommerce.repository.ItemCarrinhoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ItemCarrinhoServiceImpl implements ItemCarrinhoService {
    private final ClientesRepository clientesRepository;
    private final ProdutoServiceImpl produtosService;
    private final CarrinhoComprasServiceImpl carrinhoComprasService;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinhoServiceImpl(ClientesRepository clientesRepository, ProdutoServiceImpl produtosService, ItemCarrinhoRepository itemCarrinhoRepository,
                                   CarrinhoComprasServiceImpl carrinhoComprasService) {
        this.clientesRepository = clientesRepository;
        this.produtosService = produtosService;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.carrinhoComprasService = carrinhoComprasService;
    }


    @Override
    public void addItemAoCarrinho(UUID clienteId, UUID produtoId) {
        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Produtos produto = produtosService.buscarPorId(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        ItemCarrinho itemCarrinho = new ItemCarrinho();
        itemCarrinho.setClientes(cliente);
        itemCarrinho.setProduto(produto);
        itemCarrinhoRepository.save(itemCarrinho);


        adicionarItemExistenteAoCarrinho(clienteId, itemCarrinho);
    }

    @Override
    public void adicionarItemExistenteAoCarrinho(UUID clienteId, ItemCarrinho itemCarrinho) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasService.verificarCarrinhoExiste(clienteId);

        carrinhoComprasService.adicionarAoCarrinho(carrinhoCompras.getId(), itemCarrinho);
    }


}
