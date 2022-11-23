package com.bankSys.BankSsy.controller;

import com.bankSys.BankSsy.entidades.Banco;
import com.bankSys.BankSsy.entidades.Deuda;
import com.bankSys.BankSsy.servicio.DeudaService;
import com.bankSys.BankSsy.util.paginacion.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class DeudaController {

    @Autowired private DeudaService service;


    /**Metodo para ver detalle deuda*/
    @GetMapping("/verdeuda/{id}")
    public String verDetalleBanco(@PathVariable(value = "id")Long id, Map<String, Object> model, RedirectAttributes ra){
        Deuda deuda = service.findOne(id);
        if (deuda == null)
        {
            ra.addFlashAttribute("error","la deuda no exite en la bb");
        }

        model.put("deuda",deuda);
        model.put("titulo","Detalles de la deuda"+ deuda.getBanco());

        return "verdeuda";
    }

    /**Metodo guardar BANCO*/
    @PostMapping("/pagardeuda")
    public String guardarDeuda(@Valid Deuda deuda, BindingResult result, Model model, RedirectAttributes ra, SessionStatus status){
        if(result.hasErrors())
        {
            model.addAttribute("titulo", "Registro de deuda");
            return "form";
        }

        String mensaje = (deuda.getId_deuda() != null) ? "Banco se edito Correactamente" : "Banco se creo con Exito..!";

        service.save(deuda);
        status.setComplete();
        ra.addFlashAttribute("success", mensaje);

        return "redirect:deudas";

    }

    /**Metodo pagar deuda*/
    @GetMapping("/pagardeuda/{id}")
    public String pagarDeuda(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes ra){
        Deuda deuda = null;
        if (id >0)
        {
            deuda = service.findOne(id);
            if (deuda == null)
            {
                ra.addFlashAttribute("error", "el ID deuda no exite DB ");
                return  "redirect:/deudas";
            }
        }
        else{
            ra.addFlashAttribute("error", "el ID deuda no puede ser 0");
            return  "redirect:/deudas";
        }

        model.put("deuda", deuda);
        model.put("titulo", "Pagar de deuda");
        return "pagardeuda";
    }




    /**metodo para listar deuda*/
    @GetMapping("/deudas")
    public String listarDeudas(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,4);
        Page<Deuda> deudas = service.findAll(pageRequest);
        PageRender<Deuda> pageRender = new PageRender<>("/deudas", deudas);

        model.addAttribute("titulo", "Deudas Bancarias");
        model.addAttribute("deudas",deudas);
        model.addAttribute("page",pageRender);

        return  "deudas";
    }

}
