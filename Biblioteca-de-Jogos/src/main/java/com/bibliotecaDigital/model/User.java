package com.bibliotecaDigital.model;


public class User {

    private final String username;
    private final int userId;
    private double balance;
    private Library library = new Library();


    //construtor
    public User(String username, double balance, int UserId) {
        this.username = username;
        this.balance = balance;
        this.userId = UserId;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
