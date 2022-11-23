package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.CustomUserDetails;
import com.bankSys.BankSsy.entidades.Usuario;
import com.bankSys.BankSsy.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repositorio;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repositorio.findByEmail(email);
        if (usuario == null)
        {
            throw new UsernameNotFoundException("Usuario no encontrado..!");
        }
        return new CustomUserDetails(usuario);
    }
}