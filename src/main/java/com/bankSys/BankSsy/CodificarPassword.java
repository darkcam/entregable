package com.bankSys.BankSsy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodificarPassword {

    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123cam";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}