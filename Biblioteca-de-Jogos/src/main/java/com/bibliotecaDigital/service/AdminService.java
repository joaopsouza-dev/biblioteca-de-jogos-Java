package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.Catalog;
import com.bibliotecaDigital.model.Game;
import com.bibliotecaDigital.model.Menu;

import java.util.Scanner;

public class AdminService {

    private final Catalog catalog;
    private final Menu menu;
    private final LibraryService libraryService;
    private final Authenticator auth;
    private final Scanner sc;

    public AdminService(Catalog catalog, LibraryService libraryService, Authenticator auth) {
        this.catalog = catalog;
        this.libraryService = libraryService;
        this.auth = auth;
        this.menu = new Menu();
        this.sc = new Scanner(System.in);
    }

    public void adminCLI() {
        int option = 0;

        while (option != 4) {

            menu.adminMenu();
            option = Integer.parseInt(sc.nextLine());

            switch (option) {

                case 1: // atualizar jogo da biblioteca
                    if (auth.passwordMatch()) {
                        libraryService.updateLibrary();
                    }
                    break;

                case 2: // remover jogo da biblioteca
                    if(auth.passwordMatch()) {
                        catalog.removeGame();
                    }
                    break;

                case 3: // criar jogo no catálogo
                    if(auth.passwordMatch()) {

                    System.out.print("Digite o nome do jogo: ");
                    String name = sc.nextLine();

                    System.out.print("Digite o valor do jogo: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Digite o ID do jogo: ");
                    int id = Integer.parseInt(sc.nextLine());

                    while (catalog.existingGame(id)) {
                        System.out.println("Digite o ID novamente: ");
                        id = Integer.parseInt(sc.nextLine());
                    }

                    System.out.print("Digite o gênero do jogo: ");
                    String genre = sc.nextLine();

                    Game game = new Game(id, name, genre, price);
                    catalog.addGame(game);

                    System.out.println("Jogo criado com sucesso!");
                }


                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}