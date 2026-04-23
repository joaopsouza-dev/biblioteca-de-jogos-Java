package com.bibliotecaDigital.model;

public class Game {

    private String name;
    private double price;
    private int id;
    private String genre;

    public Game(int id, String name, String genre, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.genre = genre;
    }

    public void showGame() {
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + name);
        System.out.println("Gênero: " + genre);
        System.out.println("ID: \"" + id + "\"");
        System.out.println("Preço: " + price + " R$");
        System.out.println("-----------------------------------\n");

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
