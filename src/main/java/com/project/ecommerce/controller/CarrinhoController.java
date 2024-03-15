package com.project.ecommerce.controller;

import com.project.ecommerce.entity.*;
import com.project.ecommerce.service.CarrinhoComprasServiceImpl;
import com.project.ecommerce.service.ClienteServiceImpl;
import com.project.ecommerce.service.ItemCarrinhoServiceImpl;
import com.project.ecommerce.service.ProdutoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
    private final CarrinhoComprasServiceImpl carrinhoComprasService;
    private final ClienteServiceImpl clienteService;
    private final ProdutoServiceImpl produtoService;
    private final ItemCarrinhoServiceImpl itemCarrinhoService;


    public CarrinhoController(CarrinhoComprasServiceImpl carrinhoComprasService, ClienteServiceImpl clienteService, ProdutoServiceImpl produtoService,
                              ItemCarrinhoServiceImpl itemCarrinhoService) {
        this.carrinhoComprasService = carrinhoComprasService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.itemCarrinhoService = itemCarrinhoService;
    }

    @PostMapping(value = "/adicionar-carrinho", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String adicionarAoCarrinho(@RequestParam("produtoId") UUID produtoId) {
        Optional<Produtos> optionalProduto = produtoService.buscarPorId(produtoId);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails userDetails) {
            String clienteEmail = userDetails.getUsername();
            if (clienteEmail != null) {
                Clientes cliente = clienteService.buscarCliente(clienteEmail);
                optionalProduto.ifPresent(produto -> {
                    itemCarrinhoService.addItemAoCarrinho(cliente.getId(), produtoId);
                });
            }
        }

        return "redirect:/produtos/";
    }

    @GetMapping("/mostrar-carrinho")
    public String showCarrinho(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) principal;
            String clienteEmail = userDetails.getUsername();
            if (clienteEmail != null) {
                Clientes cliente = clienteService.buscarCliente(clienteEmail);
                List<ItemCarrinho> itemCarrinhoList = carrinhoComprasService.getCarrinhoItemsValidos(cliente.getId());
                model.addAttribute("itensCarrinho", itemCarrinhoList);
            }
        }
        return "produtos-carrinho";
    }




}
