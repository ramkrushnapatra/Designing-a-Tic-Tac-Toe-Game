package org.example;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
    }

    public void play(){
        board.printBoard();
        while (!board.isFull()){
            System.out.println(currentPlayer.getPlayerName() + "'s turn."+ currentPlayer.getSymbol());

            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");
            try{
                board.makeMoves(row, col, currentPlayer.getSymbol());
                board.printBoard();
            }
            catch (Exception e){
                throw  new RuntimeException("Exception");
            }
            if (board.hasWinner(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getPlayerName() + " wins!");
                return;
            }
            if(board.isFull()){
                System.out.println("draw");
            }
            switchPlayer();
//            } else {
//                System.out.println("It's a draw!");
//            }
        }
    }
    public int getValidInput(String message){
        System.out.println(message);
        Scanner scanner= new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        if (input < 0 && input > 2) {
            throw  new RuntimeException("invalid input");
        }
        return input;
    }

    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
