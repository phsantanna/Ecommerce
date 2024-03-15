package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Clientes;
import com.project.ecommerce.entity.CustomUserDetails;
import com.project.ecommerce.entity.Pedidos;
import com.project.ecommerce.service.ClienteServiceImpl;
import com.project.ecommerce.service.PedidosServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")

public class PedidosController {
    private final PedidosServiceImpl pedidosService;
    private final ClienteServiceImpl clienteService;

    public PedidosController(PedidosServiceImpl pedidosService, ClienteServiceImpl clienteService) {
        this.pedidosService = pedidosService;
        this.clienteService = clienteService;
    }

    @PostMapping("/{clienteId}")
    public String criarPedido(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String clienteEmail = userDetails.getUsername();
            if (clienteEmail != null) {
                Clientes cliente = clienteService.buscarCliente(clienteEmail);

                pedidosService.criarPedido(cliente.getId());
            }
        }
        return "produtos-carrinho";
    }

    @GetMapping("/listar-pedidos")
    public String showPedidos(Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String clienteEmail = userDetails.getUsername();
            if (clienteEmail != null) {
                Clientes cliente = clienteService.buscarCliente(clienteEmail);

                List<Pedidos> pedidos = pedidosService.getAllPedidosByCliente(cliente.getId());
                model.addAttribute("pedidos", pedidos);
            }
        }
        return "pedidos";
    }

}
