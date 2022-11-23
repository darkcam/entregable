package com.bankSys.BankSsy.controller;

import com.bankSys.BankSsy.entidades.DeudaCliente;
import com.bankSys.BankSsy.servicio.DeudaClienteService;
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
public class DeudaClienteController {

    @Autowired private DeudaClienteService service;

    /**Metodo Listar deuda*/
    @GetMapping("/deuda")
    public String listarDuedaCliente(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,5);
        Page<DeudaCliente> deudas = service.findAll(pageRequest);
        PageRender<DeudaCliente> pageRender = new PageRender<>("/deuda", deudas);

        model.addAttribute("titulo", "OBLIGACIONES BANCARIAS");
        model.addAttribute("duedas", deudas);
        model.addAttribute("page", pageRender);

        return "deuda";

    }

}
