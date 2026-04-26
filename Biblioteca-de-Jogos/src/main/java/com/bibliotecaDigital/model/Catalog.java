package com.bibliotecaDigital.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {

    /* essa classe serve para instanciar os jogos que ja estarao pre definidos na plataforma.
    eles poderao ser adicionados pelo usuario dentro da biblioteca caso ele pague o valor e
    tambem tenha valor suficiente na conta
     */

    private final List<Game> games;

    public Catalog() {
        games = new ArrayList<>();

        games.add(new Game(12938, "FC 26", "Esportes", 189.90));
        games.add(new Game(43109, "God Of War: Ragnarock", "Ação / História", 249.90));
        games.add(new Game(17498, "ResidentEvil 9: Requiem", "Terror / Suspense", 189.90));
        games.add(new Game(16438, "Clair Obscur: Expedition 33", "Ação / História", 199.90));
        games.add(new Game(12093, "Minecraft: Java Edition", "Simulação", 79.90));
        games.add(new Game(76154, "Forza Horizon 5", "Simulação / Corrida", 349.90));
    }


    public void showCatalog() {
        System.out.println("\n========== LISTA DE JOGOS DISPONÍVEIS ==========\n");
        for (Game game : games) { //mostrar a lista de jogos
            game.showGame();
        }
    }

    public Game findGame(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o id do jogo ou 0 para cancelar: ");
        int id = sc.nextInt();

        if (id == 0) {
            return;
        }

        for (Game game : games) {

            if (game.getId() == id) {
                games.remove(game);
                System.out.println("Jogo removido com sucesso!");
                return;
            }
        }

        System.out.println("Jogo não encontrado");
    }

}
