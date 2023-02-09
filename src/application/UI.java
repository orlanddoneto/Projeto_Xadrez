package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.Position;
import game.Color;
import game.GamePiece;
import game.GamePosition;

public class UI {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	
	public static GamePosition readPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char col = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new GamePosition(col, row);
		}
		catch(Exception e) {
			throw new InputMismatchException("Posição inválida!");
		}
	}
	public static void clear() {
		
		System.out.flush();
		System.out.print("\033[H\033[2J");
		
	}
	
	public static void printBoard(GamePiece[][]pieces) {
		
		int temp = pieces.length;
		for (int i = 0; i<pieces.length;i++) {
			System.out.print(temp+"| ");
			temp -= 1;
			
			for (int j = 0; j<pieces.length;j++)
				printPiece(pieces[i][j], false);
				System.out.print("|");
				if(i==7) {
					System.out.println();
					break;
				}
			System.out.println();
		}
		System.out.println(" -------------------");
		System.out.print("   a b c d e f g h");
	}
	
	public static void printBoard(GamePiece[][]pieces, boolean[][] possibleMove) {
		
		int temp = pieces.length;
		for (int i = 0; i<pieces.length;i++) {
			System.out.print(temp+"| ");
			temp -= 1;
			
			for (int j = 0; j<pieces.length;j++)
				printPiece(pieces[i][j], possibleMove[i][j]);
				System.out.print("|");
				if(i==7) {
					System.out.println();
					break;
				}
				
			System.out.println();
		}
		System.out.println(" -------------------");
		System.out.print("   a b c d e f g h");
	}
	
	public static void printPiece(GamePiece piece, boolean possibleMove) {
		if (possibleMove) {
			System.out.print(ANSI_YELLOW_BACKGROUND);
		}
		if (piece == null) {
			System.out.print("-"+ANSI_RESET);
		}
		
		else if(piece.getColor()==Color.WHITE) {
			System.out.print(ANSI_WHITE+ piece+ ANSI_RESET);
		}
		else
			System.out.print(ANSI_CYAN+ piece+ ANSI_RESET);
		System.out.print(" ");
	
			
	}
	
	
	
}
