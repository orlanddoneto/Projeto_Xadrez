package chess_pieces;

import board.BoardGame;
import game.Color;
import game.GamePiece;

public class Queen extends GamePiece{

	public Queen(BoardGame board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possiblesMoves() {
		boolean [][] mat = new boolean[8][8];
		for (int i = 0; i<8;i++) {
			for(int j = 0;j<8;j++) {
				mat[i][j] = false;
			}
		}
		return mat;
	}

}