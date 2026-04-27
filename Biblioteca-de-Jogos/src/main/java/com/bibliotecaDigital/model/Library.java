package com.bibliotecaDigital.model;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private int gameQ;

    private List<Game> library;

    public Library() {
        library = new ArrayList<>();
    }

    public void addGame(Game game) {
        library.add(game);
        gameQ++;
    }

    public void removeGame(Game game) {
        library.remove(game);
        gameQ--;
    }

    public void showLibrary() {
        for (Game game : library) {
            game.showGame();
        }
    }

    public boolean hasGame(int id) {
        for (Game game : library) {
            if (game.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getGameQ() {
        return gameQ;
    }

    public Game findGame(int id) {
        for (Game g : library) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }
}
