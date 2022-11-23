package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.DeudaCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeudaClienteService {

    public List<DeudaCliente> findAll();

    public Page<DeudaCliente> findAll(Pageable pageable);

    public void save(DeudaCliente deudaCliente);

    public DeudaCliente findOne(Long id);

    public void delete(Long id);

}
