package com.bibliotecaDigital.model;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);


    public void showMenu() {

        System.out.println("\n==================== MENU ====================");
        System.out.println("Escolha a opção desejada:\n");
        System.out.println("1. Opções do Usuário (infos / saldo / depósito)");
        System.out.println("2. Adicionar Jogo");
        System.out.println("3. Atualizar informações do jogo (admin)");
        System.out.println("4. Listar Jogos na sua biblioteca");
        System.out.println("5. Remover jogo da biblioteca (admin)");
        System.out.println("6. Sair do menu");
        System.out.println("==============================================\n");
    }

    public void userMenu() {
        System.out.println("\n================ MENU DO USUÁRIO ================");
        System.out.println("Escolha a opção desejada:\n");
        System.out.println("1. Informações do usuário");
        System.out.println("2. Saldo disponivel");
        System.out.println("3. Depósito");
        System.out.println("4. Voltar ao menu principal");
        System.out.println("================================================\n");
    }

    public int option() {
        return sc.nextInt();
    }

    public void updateGame(Game game) {
        System.out.println("\n================================================\n");
        System.out.println("Oque você deseja alterar do jogo " + game.getName() + "?");
        System.out.println("1. Nome do jogo");
        System.out.println("2. ID do jogo");
        System.out.println("3. Gênero do jogo");
        System.out.println("4. Valor do jogo");
        System.out.println("5. Voltar ao menu principal");
        System.out.println("================================================\n");
    }

}
