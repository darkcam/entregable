package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.Deuda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeudaService {

    public List<Deuda> findAll();

    public Page<Deuda> findAll(Pageable pegeable);

    public void save(Deuda deuda);

    public Deuda findOne(Long id);

    public void delete(Long id);
}
