package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.DeudaCliente;
import com.bankSys.BankSsy.repositorio.DeudaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeudaClienteImpl implements  DeudaClienteService{

    @Autowired private DeudaClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<DeudaCliente> findAll() {
        return (List<DeudaCliente>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DeudaCliente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(DeudaCliente deudaCliente) {
        repository.save(deudaCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public DeudaCliente findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
