package edu.umuc.tictactoe.controller;

import edu.umuc.tictactoe.model.Player;
import edu.umuc.tictactoe.view.Board;

public class Game {
    private Board board;
    private Player playerOne, playerTwo;
    private int turn = 1;
    private boolean continueGame = true;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public boolean isMoveInvalid(int row, int column) {
        return !((-1 < row && row < 3) && (-1 < column && column < 3)) || !board.isEmpty(row, column);
    }

    public void move(Player player, int row, int column) {
        board.mark(player.getSymbol(), row, column);
    }

    public void updateBoard()           				{board.draw();}
    public int getTurn()                				{return turn;}
    public int endTurn()								{return turn++;}
    public String getPlayerOneName()    				{return playerOne.getName();}
    public String getPlayerTwoName()    				{return playerTwo.getName();}
    public Board getBoard()								{return board;}
    public boolean getContinueGame()					{return continueGame;}
    public void setContinueGame(boolean continueGame)	{this.continueGame = continueGame;}
}