package com.bibliotecaDigital.model;
import java.util.Scanner;


public class User {

    private final String username;
    private final int userId;
    private double balance;
    private final Scanner sc = new Scanner(System.in);


    //construtor
    public User(String username, double balance, int UserId) {
        this.username = username;
        this.balance = balance;
        this.userId = UserId;
    }

    //toString para infos do usuario
    @Override
    public String toString() {
        return "USER INFOS:\n" +
                "Nome: " + this.username + "\n" +
                "ID do usuário: " + this.userId + "\n" +
                "Saldo atual: " + balance + "\n";
    }

    //ver o valor atual na conta
    public void Balance() {
        System.out.println("Saldo disponível: " + this.balance + "\n");
    }

    //depositar mais grana na conta para poder comprar mais jogos
    public void deposit() {
        double amount;
        System.out.println("Digite o valor a ser depositado:\n");
        amount = sc.nextDouble();
        this.balance += amount;
        System.out.println("Saldo atualizado com sucesso: " + this.balance + "\n");

    }
}
