package edu.umuc.tictactoe;

import edu.umuc.tictactoe.controller.Game;
import edu.umuc.tictactoe.model.Player;
import edu.umuc.tictactoe.view.Board;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe v. 1.0");

        Scanner keyboard = new Scanner(System.in);
        
        String continueGame = null;
        
        do {
        	
	        System.out.print("\nEnter name for player one: ");
	        String name = keyboard.nextLine();
	        Player playerOne = new Player(name, 'X');
	
	        System.out.print("Enter name for player two: ");
	        name = keyboard.nextLine();
	        Player playerTwo = new Player(name, 'O');
	
	        Board board = new Board();
	
	        Game game = new Game(board, playerOne, playerTwo);
	
	        do {
	        	
	            System.out.println();
	            game.updateBoard();
	            
	            if ((game.getTurn() % 2) == 1) {
	            	
	                System.out.print("\n" + game.getPlayerOneName() + ", select your move (row[1-3] column[1-3]): ");
	                String selection = keyboard.nextLine();
	                String[] splitString = selection.split(" ");
	                
	                while (game.isMoveInvalid(Integer.valueOf(splitString[0]) - 1, Integer.valueOf(splitString[1]) - 1)) {
	                    System.out.println();
	                    game.updateBoard();
	                    System.out.println("\nThis move at " + splitString[0] + " " + splitString[1] + " is not valid.  Try again...");
	                    System.out.print("\n" + game.getPlayerOneName() + ", select your move (row[1-3] column[1-3]): ");
	                    selection = keyboard.nextLine();
	                    splitString = selection.split(" ");
	                }
	                
	                game.move(playerOne, Integer.valueOf(splitString[0]) - 1, Integer.valueOf(splitString[1]) - 1);
	                
	            } else {
	            	
	                System.out.print("\n" + game.getPlayerTwoName() + ", select your move (row[1-3] column[1-3]): ");
	                String selection = keyboard.nextLine();
	                String[] splitString = selection.split(" ");
	                
	                while (game.isMoveInvalid(Integer.valueOf(splitString[0]) - 1, Integer.valueOf(splitString[1]) - 1)) {
	                    System.out.println();
	                    game.updateBoard();
	                    System.out.println("\nThis move at " + splitString[0] + " " + splitString[1] + " is not valid.  Try again...");
	                    System.out.print("\n" + game.getPlayerTwoName() + ", select your move (row[1-3] column[1-3]): ");
	                    selection = keyboard.nextLine();
	                    splitString = selection.split(" ");
	                }
	                
	                game.move(playerTwo, Integer.valueOf(splitString[0]) - 1, Integer.valueOf(splitString[1]) - 1);
	                
	            }
	            
	            game.endTurn();
	            
	        } while (game.getContinueGame());
	        
	        System.out.print("\nPlay again? (Y or N): ");
	        continueGame = keyboard.nextLine();
	        
	        while (!"Y".equalsIgnoreCase(continueGame) && !"N".equalsIgnoreCase(continueGame)) {
	        	System.out.println("\nChoice is not valid.  Try again...");
	        	System.out.print("\nPlay again? (Y or N): ");
	        	continueGame = keyboard.nextLine();
	        }
	        
        } while("Y".equalsIgnoreCase(continueGame));
        
        keyboard.close();
    }
}