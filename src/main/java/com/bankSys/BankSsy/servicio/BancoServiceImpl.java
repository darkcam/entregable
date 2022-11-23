package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.Banco;
import com.bankSys.BankSsy.repositorio.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BancoServiceImpl implements  BancoService{

    @Autowired private BancoRepository repository;



    @Override
    @Transactional(readOnly = true)
    public List<Banco> findAll() {
        return (List<Banco>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Banco> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Banco banco) {
        repository.save(banco);
    }

    @Override
    @Transactional(readOnly = true)
    public Banco findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
