package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.Game;
import com.bibliotecaDigital.model.Menu;
import com.bibliotecaDigital.model.User;

import java.util.Scanner;

public class UserService {
    private final User user;
    private final Scanner sc = new Scanner(System.in);
    private final Menu menu = new Menu();

    public UserService(User user) {
        this.user = user;
    }

    public void userInfo() {
        int option = 0;

        while (option != 4) {

            menu.userMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println(showUserInfos());
                    break;

                case 2:
                    viewBalance();
                    break;


                case 3:
                    deposit();
                    break;
            }

        }
    }

    //infos do usuario
    public String showUserInfos() {
        return "USER INFOS:\n" +
                "Nome: " + user.getUsername() + "\n" +
                "ID do usuário: " + user.getUserId() + "\n" +
                "Saldo atual: " + String.format("%.3f", user.getBalance()) + "\n";
    }

    //depositar mais grana na conta para poder comprar mais jogos
    public void deposit() {
        double amount;
        System.out.println("Digite o valor a ser depositado:\n");
        amount = sc.nextDouble();
        amount += user.getBalance();
        user.setBalance(amount);
        System.out.printf("Saldo atualizado com sucesso: %.2f \n", user.getBalance());

    }

    //ver o valor atual na conta
    public void viewBalance() {
        System.out.printf("Saldo disponível: %.2f\n", user.getBalance());
    }

    public void payGame(Game game) {

        if (user.getBalance() > game.getPrice()) {
            user.setBalance(user.getBalance() - game.getPrice());
            System.out.printf("Jogo pago com sucesso! Saldo atual: %.2f\n", user.getBalance());
        } else {
            System.out.println("Não foi possível completar o pagamento! Verifique seu saldo atual");
        }
    }

    public User getUser() {
        return user;
    }
}
