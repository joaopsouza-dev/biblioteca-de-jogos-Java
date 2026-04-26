package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.Catalog;
import com.bibliotecaDigital.model.Game;
import com.bibliotecaDigital.model.Library;
import com.bibliotecaDigital.model.Menu;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class LibraryService {
    Library library;
    private Scanner sc = new Scanner(System.in);
    private UserService userService;
    private Catalog catalog;
    Menu menu = new Menu();

    public LibraryService(UserService userService, Catalog catalog) {
        this.userService = userService;
        this.catalog = catalog;
        this.library = new Library();
    }

    public void addGame() {

        System.out.println("Digite o id do jogo ou 0 para sair: ");
        int id = sc.nextInt();
        if (id == 0) {
            return;
        }
        Game jogonovo = this.catalog.findGame(id);

        if (jogonovo == null) {
            System.out.println("Jogo não encontrado!");
            return;
        }

        if (library.hasGame(jogonovo.getId())) {
            System.out.println("Você já possui esse jogo!");
            return;
        }

        if (userService.getUser().getBalance() < jogonovo.getPrice()) {
            System.out.println("Saldo insuficiente!");
            return;
        }


        userService.payGame(jogonovo);
        library.addGame(jogonovo);
        System.out.println("Jogo adicionado com sucesso!");


    }

    public void removeGame() {
        System.out.println("Digite o id do jogo ou 0 para cancelar: ");
        int id = sc.nextInt();
        if (id == 0) {
            return;
        }
        Game rJogo = this.catalog.findGame(id);

        if (rJogo == null) {
            System.out.println("Jogo não encontrado");
            return;
        }

        if (library.hasGame(rJogo.getId())) {
            library.removeGame(rJogo);
            System.out.println("Jogo removido com sucesso!");
            return;
        }

        System.out.println("Erro no processo de remoção do jogo");

    }

    public void showLibrary() {
        System.out.println("Total de jogos na sua biblioteca: " + library.getGameQ());
        System.out.println("Jogos:\n");
        library.showLibrary();
    }

    public void updateLibrary() {
        System.out.println("Digite o id do jogo ou  0 para sair: ");
        int id = sc.nextInt();
        if (id == 0) {
            return;
        }
        Game updJogo = this.catalog.findGame(id);

        if (updJogo == null) {
            System.out.println("Jogo não encontrado!");
            return;
        }

        int option = 0;
        while (option != 5) {

            menu.updateGame(updJogo);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: //nome
                    System.out.println("Digite o novo nome ou 0 para cancelar: ");
                    String nome = sc.nextLine();

                    if (nome.equals("0")) {
                        return;
                    }

                    updJogo.setName(nome);
                    System.out.println("Nome atualizado com sucesso!");
                    break;

                case 2: //id
                    System.out.println("Digite o ID novo ou 0 para cancelar: ");
                    int identificador = sc.nextInt();

                    if (identificador == 0) {
                        return;
                    }
                    updJogo.setId(identificador);
                    System.out.println("ID atualizado com sucesso!");
                    break;

                case 3: //Gênero
                    System.out.println("Digite o gênero novo ou 0 para cancelar: ");
                    String genero = sc.nextLine();

                    if (genero.equals("0")) {
                        return;
                    }

                    updJogo.setGenre(genero);
                    System.out.println("Gênero atualizado com sucesso!");
                    break;

                case 4: //valor
                    System.out.println("Digite o novo valor ou 0 para cancelar: ");
                    double valor = sc.nextDouble();

                    if (valor == 0) {
                        return;
                    }

                    updJogo.setPrice(valor);
                    System.out.println("Valor atualizado com sucesso!");
                    break;

                case 5: //voltar
                    System.out.println("\nVoltando...\n\n");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }
    }

    public void askRefund() {

        System.out.println("Digite o id do jogo que você deseja reembolsar ou digite 0 para sair: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id == 0) {
            return;
        }

        Game jogo = this.catalog.findGame(id);

        if (jogo == null) {
            System.out.println("Jogo não encontrado!");
            return;
        }

        if (library.hasGame(jogo.getId())) {
            System.out.println("Qual foi a data que você comprou esse jogo?");
            String inputDate = sc.nextLine();

            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(inputDate, formatter);
                LocalDate today = LocalDate.now();

                long days = ChronoUnit.DAYS.between(date, today);

                if (days <= 15 && days >= 0) {

                    library.removeGame(jogo);
                    userService.getUser().setBalance(userService.getUser().getBalance() + jogo.getPrice());

                    System.out.println("Jogo reembolsado com sucesso!");

                } else {
                    System.out.println("Você não pode mais pedir reembolso, pois seu prazo acabou!");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Data inválida!");
            }

        }
    }
}
