package com.bibliotecaDigital.model;

public class Game {

    private final String name;
    private final double price;
    private final int id;
    private final String genre;

    public Game(int id, String name, String genre, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.genre = genre;
    }

    public void showList() {
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + name);
        System.out.println("Gênero: " + genre);
        System.out.println("ID: \"" + id + "\"");
        System.out.println("Preço: " + price + " R$");
        System.out.println("-----------------------------------\n");

    }



}
