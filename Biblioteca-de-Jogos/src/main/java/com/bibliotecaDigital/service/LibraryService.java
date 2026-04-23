package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.Catalog;
import com.bibliotecaDigital.model.Game;
import com.bibliotecaDigital.model.Library;
import com.bibliotecaDigital.model.Menu;

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

        System.out.println("Digite o id do jogo: ");
        int id = sc.nextInt();
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
        System.out.println("Digite o id do jogo: ");
        int id = sc.nextInt();
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
        System.out.println("Digite o id do jogo: ");
        int id = sc.nextInt();
        Game updJogo = this.library.findGame(id);

        if (updJogo == null) {
            System.out.println("Jogo não encontrado!");
            return;
        }

        if (library.hasGame(updJogo.getId())) {

            int option = 0;
            while (option != 5) {

                menu.updateGame(updJogo);
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1: //nome
                        System.out.println("Digite o novo nome: ");
                        String nome = sc.nextLine();
                        updJogo.setName(nome);
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2: //id
                        System.out.println("Digite o ID novo: ");
                        int identificador = sc.nextInt();
                        updJogo.setId(identificador);
                        System.out.println("ID atualizado com sucesso!");
                        break;

                    case 3: //Gênero
                        System.out.println("Digite o gênero novo: ");
                        String genero = sc.nextLine();
                        updJogo.setGenre(genero);
                        System.out.println("Gênero atualizado com sucesso!");
                        break;

                    case 4: //valor
                        System.out.println("Digite o novo valor: ");
                        double valor = sc.nextDouble();
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
    }
}
