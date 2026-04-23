package com.bibliotecaDigital.service;

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
                    System.out.println(user.toString());
                    break;

                case 2:
                    user.Balance();
                    break;


                case 3:
                    user.deposit();
                    break;
            }

        }
    }
}
