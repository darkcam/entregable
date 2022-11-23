package com.bankSys.BankSsy.entidades;

import javax.persistence.*;

@Entity
@Table(name="tm_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    @Column(nullable = false,length =  80, name = "nombre")
    private String nombre;
    @Column(nullable = false,length =  80,name = "apellido")
    private String apellido;
    @Column(nullable = false,unique = false, length = 150)
    private String email;
    @Column(nullable = false,length =  11, name = "cedula")
    private Integer cedula;
    @Column(nullable = false,length =  20, name = "celular")
    private Integer celular;
    @Column(nullable = false,length =  250)
    private String password;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}