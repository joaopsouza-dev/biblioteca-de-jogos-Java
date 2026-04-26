package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.*;


public class   App {

    /*
    essa é quase como uma main secundária. para não encher a main de instâncias
    de objetos e também de métodos, o app faz tudo isso e na main eu só chamo o app.start
     */

    private Authenticator auth = new Authenticator();
    private Menu menu = new Menu();
    private Catalog catalog = new Catalog();
    private UserService userService;
    private LibraryService libraryService;
    private User user;
    private AdminService adminService;

    public App() {
        this.user = new User("João", 500.0, 120394);
        this.userService = new UserService(user);
        this.libraryService = new LibraryService(userService, catalog);
        this.adminService = new AdminService(catalog, libraryService, auth);
    }


    public void start() {
        int Useroption = 0;
        this.auth.setPassword("Grupo1");

        while (Useroption != 8) {

            this.menu.showMenu();
            Useroption = this.menu.option();

            switch (Useroption) {

                case 1: //outro menu para o usuario
                    userService.userInfo();
                    break;

                case 2: // interface do admin
                    adminService.adminCLI();
                    break;

                case 3: //mostrar catálogo
                    this.catalog.showCatalog();
                    break;

                case 4: //Comprar jogo
                    this.catalog.showCatalog();
                    this.libraryService.addGame();

                    break;

                case 5: //listar jogos da biblioteca
                    this.libraryService.showLibrary();

                    break;

                case 6: //Remover jogos da biblioteca
                    this.libraryService.removeGame();
                    break;

                case 7: // reembolso
                    this.libraryService.askRefund();
                    break;

                case 8: // sair
                    System.out.println("\nSistema finalizado com sucesso! Até mais ...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Digite novamente.\n");
                    break;
            }
        }
    }
}
