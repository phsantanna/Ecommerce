package com.project.ecommerce.controller;

import com.project.ecommerce.DTO.ProdutosDto;
import com.project.ecommerce.entity.Produtos;
import com.project.ecommerce.service.ProdutoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    public final ProdutoServiceImpl produtosService;

    public ProdutoController(ProdutoServiceImpl produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        List<Produtos> products = produtosService.listarProdutos();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/criar-produto")
    public String criarProduto(@ModelAttribute ProdutosDto produtosDto){
        produtosService.criarProduto(produtosDto);
        return "redirect:/produtos/listar-produtos";
    }

    @GetMapping("/listar-produtos")
    public String listarProdutos(Model model){
        List<Produtos> produtosList = produtosService.listarProdutos();
        model.addAttribute("produtos",produtosList);
        return "gerenciar-produtos";
    }
}
