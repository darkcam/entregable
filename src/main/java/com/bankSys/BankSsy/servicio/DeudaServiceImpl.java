package com.bankSys.BankSsy.servicio;

import com.bankSys.BankSsy.entidades.Deuda;
import com.bankSys.BankSsy.repositorio.DeudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeudaServiceImpl implements  DeudaService{

    @Autowired private DeudaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Deuda> findAll() {
        return (List<Deuda>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Deuda> findAll(Pageable pegeable) {
        return repository.findAll(pegeable);
    }

    @Override
    @Transactional
    public void save(Deuda deuda) {
        repository.save(deuda);
    }

    @Override
    @Transactional(readOnly = true)
    public Deuda findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
