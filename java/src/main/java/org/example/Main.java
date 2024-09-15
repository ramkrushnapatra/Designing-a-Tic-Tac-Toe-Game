package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Player player1 = new Player("ram",'X');
        Player player2 = new Player("sham",'O');
        Game game = new Game(player1, player2);
        game.play();
    }
}