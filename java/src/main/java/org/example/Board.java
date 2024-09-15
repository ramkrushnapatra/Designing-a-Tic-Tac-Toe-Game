package org.example;

public class Board {
    private char[][] grid;
    private int movesCount;

    public Board() {
        grid = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '_';
            }
        }
        movesCount = 0;
    }

    public boolean isFull() {
        return movesCount == 9;
    }

    public void makeMoves(int row, int column, char symbol) {
        if (row < 0 || row > 3 || column < 0 || column > 3 || grid[row][column] != '_') {
            throw new IllegalArgumentException("invalid moves");
        }
        grid[row][column] = symbol;
        movesCount++;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean hasWinner(char symbol) {
        return checkColumn(symbol) || checkRow(symbol) || checkDiagonally(symbol);

    }


    public boolean checkColumn(char symbol) {
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (grid[col][row] == symbol) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRow(char symbol) {
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (grid[col][row] == symbol) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonally(char symbol){
        return checkLeftToButtom(symbol) || checkRightToButtom(symbol);
    }

    public boolean checkLeftToButtom(char symbol){
        int count=0;
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                if(row==col){
                    if(grid[row][col]==symbol){
                        count++;
                    }
                }
            }
        }
        return count ==3;
    }
    public boolean checkRightToButtom(char symbol){
        int count=0;
        for(int row=2;row>=0;row--){
            for(int col=2;col>=0;col--){
                if(row==col){
                    if(grid[row][col]==symbol){
                        count++;
                    }
                }
            }
        }
        return count ==3;
    }
}





