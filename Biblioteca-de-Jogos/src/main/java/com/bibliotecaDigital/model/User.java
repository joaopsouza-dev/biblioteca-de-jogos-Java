package com.bibliotecaDigital.model;

import com.bibliotecaDigital.service.Authenticator;

import java.util.Scanner;

import static java.lang.System.exit;

public class User {
    private String username;
    private double balance;
    private Authenticator authenticator;

    public void passwordMatch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String userPassword = input.nextLine();

        if (!authenticator.getPassword().equals(userPassword)) {
            System.out.println("Senha incorreta!");
            System.exit(1);
        }
    }

}
