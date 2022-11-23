package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.Usuario;
import com.bankSys.BankSsy.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    public Usuario get(Integer id) throws UsernameNotFoundException {
        Optional<Usuario> resultado = repositorio.findById(id);
        if(resultado.isPresent())
        {
            return resultado.get();
        }
        throw new UsernameNotFoundException("NO SE ECONTRO EL USUARIO CON ID"+ id);

    }




}
