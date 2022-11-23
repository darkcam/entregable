package com.bankSys.BankSsy.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tm_deuda")
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_deuda;
    @NotEmpty
    private String banco;

    private Integer deuda;

    private Integer cuotas;

    private Integer abono;

    public Long getId_deuda() {
        return id_deuda;
    }

    public void setId_deuda(Long id_deuda) {
        this.id_deuda = id_deuda;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Integer getDeuda() {
        return deuda;
    }

    public void setDeuda(Integer deuda) {
        this.deuda = deuda;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getAbono() {
        return abono;
    }

    public void setAbono(Integer abono) {
        this.abono = abono;
    }
}
