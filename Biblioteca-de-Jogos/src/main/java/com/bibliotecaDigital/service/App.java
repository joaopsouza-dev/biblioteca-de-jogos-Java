package com.bibliotecaDigital.service;

import com.bibliotecaDigital.model.Functions;
import com.bibliotecaDigital.model.Menu;


public class App {

    Authenticator auth = new Authenticator();
    Functions functions = new Functions();
    Menu menu = new Menu();


    public void start() {
        int Useroption = 0;
        this.auth.setPassword("Grupo1");

        while (Useroption != 5) {

            this.menu.showMenu();
            Useroption = this.menu.option();

            switch (Useroption) {

                case 1:
                    this.functions.addGame();
                    break;

                case 2:
                    this.functions.listGame();
                    break;

                case 3:
                    this.auth.passwordMatch();
                    this.functions.removeGame();
                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("\nSistema finalizado com sucesso! Até mais ...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Digite novamente.\n");
                    break;
            }
        }
    }
}
