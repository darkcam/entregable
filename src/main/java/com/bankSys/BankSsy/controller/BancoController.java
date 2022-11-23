package com.bankSys.BankSsy.controller;

import com.bankSys.BankSsy.entidades.Banco;
import com.bankSys.BankSsy.servicio.BancoService;
import com.bankSys.BankSsy.util.paginacion.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class BancoController {

    @Autowired private BancoService service;
    /**Metodo para ver banco*/
    @GetMapping("/ver/{id}")
    public String verDetallesBanco(@PathVariable(value = "id")Long id, Map<String, Object> model, RedirectAttributes ra){
        Banco banco = service.findOne(id);
        if(banco == null)
        {
            ra.addFlashAttribute("error", "EL BANCO NO EXITE EN LA BASE DE DARTOS");

            return "redirect:/listar";
        }

        model.put("banco", banco);
        model.put("titulo", "Detalles del Banco"+ banco.getNombreBanco());

        return "ver";
    }
    /**Metodo registrar banco*/
    @GetMapping("/form")
    public String mostrarFormRegistroBanco(Map<String, Object> model){
        Banco banco = new Banco();
        model.put("banco", banco);
        model.put("titulo", "Registro de Banco");

        return "form";
    }

    /**Metodo guardar BANCO*/
    @PostMapping("/form")
    public String guardarBanco(@Valid Banco banco, BindingResult result, Model model, RedirectAttributes ra, SessionStatus status){
        if(result.hasErrors())
        {
            model.addAttribute("titulo", "Registro de Banco");
            return "form";
        }

        String mensaje = (banco.getId() != null) ? "Banco se edito Correactamente" : "Banco se creo con Exito..!";

        service.save(banco);
        status.setComplete();
        ra.addFlashAttribute("success", mensaje);

        return "redirect:listar";

    }

    /**Metodo para editar*/
    @GetMapping("/form/{id}")
    public String editarBanoc(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes ra){
        Banco banco = null;
        if (id >0)
        {
            banco = service.findOne(id);
            if (banco == null)
            {
                ra.addFlashAttribute("error", "el ID Banco no exite DB ");
                return  "redirect:/listar";
            }
        }
        else{
            ra.addFlashAttribute("error", "el ID Banco no puede ser 0");
            return  "redirect:/listar";
        }

        model.put("banco", banco);
        model.put("titulo", "Edicion de Bancos");
        return "form";
    }
    /**Metodo Eliminar Banco*/
    @GetMapping("/eliminar/{id}")
    public String eliminarBanco(@PathVariable(value = "id") long id, RedirectAttributes ra){
        if (id >0)
        {
            service.delete(id);
            ra.addFlashAttribute("success", "Eliminado Bancon con exito");
        }
        return  "redirect:/listar";
    }

    /**Metodo Listar Bancos*/
    @GetMapping({"/","listar",""})
    public String listarBancos(@RequestParam(name ="page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,4);
        Page<Banco> bancos = service.findAll(pageRequest);
        PageRender<Banco> pageRender = new PageRender<>("/listar", bancos);

        model.addAttribute("titulo","Listado de bancos");
        model.addAttribute("bancos", bancos);
        model.addAttribute("page", pageRender);

        return  "listar";
    }
}
