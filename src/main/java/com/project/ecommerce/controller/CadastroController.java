package com.project.ecommerce.controller;


import com.project.ecommerce.DTO.CadastroDto;
import com.project.ecommerce.service.ClienteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/clientes")
public class CadastroController {
    private final ClienteServiceImpl clienteService;
    public CadastroController(ClienteServiceImpl clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/cadastrar")
    public String showLoginForm(){
        return "register";
    }
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute CadastroDto cadastroDto, Model model) throws NoSuchAlgorithmException {
        model.addAttribute("signupForm", cadastroDto);
        clienteService.cadastro(cadastroDto);
        return "redirect:/clientes/login";
    }

}
