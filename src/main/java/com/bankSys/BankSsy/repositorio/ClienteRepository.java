package com.bankSys.BankSsy.repositorio;

import com.bankSys.BankSsy.entidades.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository  extends PagingAndSortingRepository<Cliente, Long> {
}
