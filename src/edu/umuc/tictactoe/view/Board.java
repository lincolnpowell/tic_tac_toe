package edu.umuc.tictactoe.view;

public class Board {
    private char[][] board = { {' ', ' ', ' '},
                               {' ', ' ', ' '},
                               {' ', ' ', ' '} };

    public Board() {}

    public void draw() {
    	System.out.println("   1  2  3");
        for (int i = 0; i < 3; i++)
            System.out.println((i + 1) + " [" + board[i][0] + "][" + board[i][1] + "][" + board[i][2] + "]");
    }

    public boolean isEmpty(int row, int column) {
        return board[row][column] == ' ';
    }

    public void mark(char symbol, int row, int column) {
        board[row][column] = symbol;
    }

    public char get(int row, int column)    {return board[row][column];}
}