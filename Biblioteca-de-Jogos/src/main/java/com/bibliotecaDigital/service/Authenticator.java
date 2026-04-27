package com.bibliotecaDigital.service;


import java.util.Scanner;

public class Authenticator {
    private String password;
    private final Scanner input = new Scanner(System.in);

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean passwordMatch() {
        System.out.print("Digite a senha ou 0 para cancelar: ");
        String userPassword = input.nextLine();

        if (userPassword.equals("0")) {
            return false;
        }

        while (!password.equals(userPassword)) {
            System.out.println("Senha incorreta! Digite a senha novamente ou 0 para sair: ");
            userPassword = input.nextLine();

            if (userPassword.equals("0")) {
                return false;
            }
        }

        System.out.println("Senha correta!");
        return true;
    }
}
