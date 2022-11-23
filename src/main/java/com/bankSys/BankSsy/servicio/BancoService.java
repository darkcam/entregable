package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.Banco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BancoService {

    public List<Banco> findAll();

    public Page<Banco> findAll(Pageable pageable);

    public void save(Banco banco);

    public Banco findOne(Long id);

    public void delete(Long id);


}
