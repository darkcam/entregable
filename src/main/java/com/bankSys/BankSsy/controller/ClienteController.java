package com.bankSys.BankSsy.controller;

import com.bankSys.BankSsy.entidades.Cliente;
import com.bankSys.BankSsy.servicio.ClienteService;
import com.bankSys.BankSsy.util.paginacion.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired private ClienteService service;

    /**Metodo para listar clientes*/
    @GetMapping("/cliente")
    private String  listarCliente(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,4);
        Page<Cliente> clientes = service.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<>("/cliente",clientes);

        model.addAttribute("titulo","listar clientes");
        model.addAttribute("clientes",clientes);
        model.addAttribute("page",pageRender);

        return "cliente";

    }
}
