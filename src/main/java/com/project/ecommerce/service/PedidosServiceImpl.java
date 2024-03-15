package com.project.ecommerce.service;

import com.project.ecommerce.entity.CarrinhoCompras;
import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.ItemCarrinho;
import com.project.ecommerce.entity.Pedidos;
import com.project.ecommerce.enums.Situacao;
import com.project.ecommerce.repository.CarrinhoComprasRepository;
import com.project.ecommerce.repository.ClientesRepository;
import com.project.ecommerce.repository.ItemCarrinhoRepository;
import com.project.ecommerce.repository.PedidosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidosServiceImpl implements PedidosService {

    private final ClientesRepository clientesRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final PedidosRepository pedidosRepository;
    private final CarrinhoComprasRepository carrinhoComprasRepository;

    public PedidosServiceImpl(ClientesRepository clientesRepository, ItemCarrinhoRepository itemCarrinhoRepository, PedidosRepository pedidosRepository,
                              CarrinhoComprasRepository carrinhoComprasRepository) {
        this.clientesRepository = clientesRepository;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.pedidosRepository = pedidosRepository;
        this.carrinhoComprasRepository = carrinhoComprasRepository;
    }


    @Override
    @Transactional
    public Pedidos criarPedido(UUID clienteId) {

        Clientes clientes = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        List<ItemCarrinho> itemsCarrinho = itemCarrinhoRepository.findByClientesId(clienteId);
        if (itemsCarrinho.isEmpty()) {
            throw new RuntimeException("Carrinho vazio.");
        }


        List<ItemCarrinho> itensNaoAssociados = itemsCarrinho.stream()
                .filter(item -> item.getPedidos() == null)
                .collect(Collectors.toList());

        if (itensNaoAssociados.isEmpty()) {
            throw new RuntimeException("Todos os itens do carrinho já foram associados a um pedido.");
        }


        Pedidos pedidos = new Pedidos();
        pedidos.setClientes(clientes);
        pedidos.setSituacao(Situacao.ANALISANDO);
        pedidos.setProdutos(itensNaoAssociados);
        pedidosRepository.save(pedidos);


        for (ItemCarrinho itemCarrinho : itensNaoAssociados) {
            itemCarrinho.setPedidos(pedidos);
        }


        itemCarrinhoRepository.deleteAll(itensNaoAssociados);

        return pedidos;
    }


    @Override
    public List<Pedidos> getAllPedidosByCliente(UUID id) {
        return pedidosRepository.findByClientesId(id);
    }

}
