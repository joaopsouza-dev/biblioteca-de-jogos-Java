package com.bibliotecaDigital.service;


import java.util.Scanner;

public class Authenticator {
    private String password;
    private final Scanner input = new Scanner(System.in);

    public void setPassword(String password) {
        this.password = password;
    }

    public void passwordMatch() {
        System.out.print("Digite a senha: ");
        String userPassword = input.nextLine();

        while (!password.equals(userPassword)) {
            System.out.println("Senha incorreta! Digite a senha novamente: ");
            userPassword = input.nextLine();
        }

        System.out.println("Senha conferida com sucesso!");
    }
}
