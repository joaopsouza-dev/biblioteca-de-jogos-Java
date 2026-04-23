package com.bibliotecaDigital.model;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);


    public void showMenu() {

        System.out.println("\n============== MENU ==============");
        System.out.println("Escolha a opção desejada:");
        System.out.println("1. Adicionar Jogo");
        System.out.println("2. Atualizar informações do jogo");
        System.out.println("3. Listar Jogos na sua biblioteca");
        System.out.println("4. Remover jogo da biblioteca");
        System.out.println("5. Sair do menu");
        System.out.println("==================================\n");
    }

    public int option() {
        return sc.nextInt();
    }

    public void password() {

    }
}
