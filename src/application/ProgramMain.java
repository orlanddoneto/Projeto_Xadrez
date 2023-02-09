package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.GameException;
import game.GamePosition;
import game.gameMatch;

public class ProgramMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		gameMatch game = new gameMatch();
		while (true) {
			try {
				UI.clear();
				UI.printBoard(game.getPieces());
				System.out.println();
				
				System.out.println("Posição Inicial: ");
				GamePosition pos1 = UI.readPosition(sc);
				
				boolean [][] possiblesMoves = game.possibleMoves(pos1);
				UI.clear();
				UI.printBoard(game.getPieces(),possiblesMoves);
				System.out.println();
				
				System.out.println("Posição Final:");
				GamePosition pos2 = UI.readPosition(sc);
				System.out.println();
				
				game.movePiece(pos1, pos2);
			}
			catch(GameException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
	}

}
