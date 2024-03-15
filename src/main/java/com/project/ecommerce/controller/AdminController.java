package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.repository.ClientesRepository;
import com.project.ecommerce.service.ClienteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ClienteServiceImpl clienteService;

    public AdminController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/painel-admin")
    public String admin() {
        return "painel-admin";
    }

    @GetMapping("/gerenciar-usuarios")
    public String gerenciaUsuarios(){
        return "gerenciar-usuarios";
    }
    @GetMapping("/listar-usuarios")
    public String listarUsuarios(Model model) {
        List<Clientes> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "gerenciar-usuarios";
    }

    @GetMapping("/gerenciar-produtos")
    public String gerenciarProdutos(){
        return "gerenciar-produtos";
    }
}
