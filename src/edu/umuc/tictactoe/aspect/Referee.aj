package edu.umuc.tictactoe.aspect;

import edu.umuc.tictactoe.controller.Game;
import edu.umuc.tictactoe.view.Board;
import edu.umuc.tictactoe.model.Player;

public aspect Referee {
	pointcut evaluateBoard(Game game):
		target(game) && 
		call(public void Game.move(Player, int, int));
	
	after(Game game) returning: evaluateBoard(game) {
		if (checkWinCondition(game.getBoard())) {
			System.out.println();
			game.updateBoard();
			if (((game.getTurn()) % 2) == 1)
                System.out.println("\n" + game.getPlayerOneName() + " wins!");
            else
            	System.out.println("\n" + game.getPlayerTwoName() + " wins!");
			game.setContinueGame(false);
		}
		
		else if (checkDrawCondition(game.getBoard())) {
			System.out.println();
			game.updateBoard();
			System.out.println("\nDraw!");
			game.setContinueGame(false);
		}
	}
	
	private boolean checkWinCondition(Board board) {
        return (checkWinConditionRows(board) || checkWinConditionColumns(board) || checkWinConditionDiagonals(board));
    }

    private boolean checkWinConditionRows(Board board) {
        for (int i = 0; i < 3; i++)
            if (checkRow(board.get(i, 0), board.get(i, 1), board.get(i, 2)))
                return true;
        return false;
    }

    private boolean checkWinConditionColumns(Board board) {
        for (int i = 0; i < 3; i++)
            if (checkRow(board.get(0, i), board.get(1, i), board.get(2, i)))
                return true;
        return false;
    }

    private boolean checkWinConditionDiagonals(Board board) {
        return ((checkRow(board.get(0, 0), board.get(1, 1), board.get(2, 2)) || checkRow(board.get(0, 2), board.get(1, 1), board.get(2, 0))));
    }

    private boolean checkRow(char a, char b, char c) {
        return ((a != ' ') && (a == b) && (b == c));
    }

    private boolean checkDrawCondition(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.get(i, j) == ' ')
                    return false;
            }
        }
        return true;
    }
}