package com.bankSys.BankSsy.repositorio;

import com.bankSys.BankSsy.entidades.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeudaRepository extends JpaRepository<Deuda, Long> {
}
