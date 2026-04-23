package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.*;


public class App {

    /*
    essa é quase como uma main secundária. para não encher a main de instâncias
    de objetos e também de métodos, o app faz tudo isso e na main eu só chamo o app.start
     */

    Authenticator auth = new Authenticator();
    Functions functions = new Functions();
    Menu menu = new Menu();
    Store store = new Store();
    UserService userService;
    private User user;

    public App() {
        this.user = new User("João", 500.0, 120394);
        this.userService = new UserService(user);
    }

    public void start() {
        int Useroption = 0;
        this.auth.setPassword("Grupo1");

        while (Useroption != 6) {

            this.menu.showMenu();
            Useroption = this.menu.option();

            switch (Useroption) {

                case 1:
                    userService.userInfo();
                    break;

                case 2:
                    this.store.showCatalog();
                    this.functions.addGame();
                    break;

                case 3:
                    this.auth.passwordMatch();
                    this.functions.updateGame();
                    break;


                case 4:
                    this.functions.listGame();
                    break;

                case 5:
                    this.auth.passwordMatch();
                    this.functions.removeGame();
                    break;

                case 6:
                    System.out.println("\nSistema finalizado com sucesso! Até mais ...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Digite novamente.\n");
                    break;
            }
        }
    }
}
