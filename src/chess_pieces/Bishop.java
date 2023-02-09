package chess_pieces;

import board.BoardGame;
import board.Position;
import game.Color;
import game.GamePiece;
import game.gameMatch;

public class Bishop extends GamePiece {

	public Bishop(BoardGame board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
		
	}

	@Override
	public boolean[][] possiblesMoves() {
		
		final boolean [] temp = new boolean[4];
		final int [][] vect = new int[4][2];
		final int [][] vectPieceEquals = new int[4][2];
		final boolean [] tempEquals = new boolean[4];
		
		Position pos1 = position;
		Position pos2;
		final boolean array [][] = new boolean[getBoard().getRows()][getBoard().getColums()];
		for (int i = 0; i<getBoard().getRows();i++) {
			for (int j = 0; j<getBoard().getColums();j++) {
				pos2 = new Position(i, j);
				
				if(Math.abs(pos1.getRow()- pos2.getRow()) == Math.abs(pos1.getColums() - pos2.getColums())) {
					if(Math.abs(pos1.getColums() - pos2.getColums())!=0){
						array[i][j] = true;
					}
				}			
			}
		}
		for (int i = 0; i<getBoard().getRows();i++) {
			for (int j = 0; j<getBoard().getColums();j++) {
				pos2 = new Position(i,j);
				
				if(array[i][j] == true) {
		
					if(getBoard().ThereIsAPiece(pos2)) {
						if(isThereOpponentPiece(pos2)) {
							validateMoves(temp, vect, i, j, array, position);
										
						}
						else
							validateMoves(tempEquals, vectPieceEquals, i, j, array, pos2);
							array[i][j] = false;
					}	
				}
			}
		}
		
		for (int i = 0; i<getBoard().getRows();i++) {
			for (int j = 0; j<getBoard().getColums();j++) {
				pos2 = new Position(i, j);
				if (position.getColums()<j && position.getRow()>i) {
					if (getBoard().ThereIsAPiece(pos2)) {
						for (int k = 0; k<getBoard().getRows();i++ ) {
							for (int l = 0;l<getBoard().getColums();i++) {
								if (array[k][l] == true &&(k<i && l>j) ) {
									array[k][l] = false;
								}
							}
						}
					}
				}
				if (position.getColums()> j && position.getRow()>i) {
					if (getBoard().ThereIsAPiece(pos2)) {
						for (int k = 0; k<getBoard().getRows();i++ ) {
							for (int l = 0;l<getBoard().getColums();i++) {
								if (array[k][l] == true &&(k<i && l<j) ) {
									array[k][l] = false;
								}
							}
						}
					}
				}
				
				if (position.getColums()>j && position.getRow()<i) {
					if (getBoard().ThereIsAPiece(pos2)) {
						for (int k = 0; k<getBoard().getRows();i++ ) {
							for (int l = 0;l<getBoard().getColums();i++) {
								if (array[k][l] == true &&(k>i && l<j) ) {
									array[k][l] = false;
								}
							}
						}
					}
				}
				
				if(position.getColums()<j && position.getRow()<i) {
					if (getBoard().ThereIsAPiece(pos2)) {
						for (int k = 0; k<getBoard().getRows();i++ ) {
							for (int l = 0;l<getBoard().getColums();i++) {
								if (array[k][l] == true &&(k>i && l>j) ) {
									array[k][l] = false;
								}
							}
						}
					}
				}
				
			}
		}
		return array;
	}
	
	public static void validateMoves(boolean [] temp, int vect[][],int i, int j, boolean[][] array, Position position) {
		if (position.getColums()<j && position.getRow()>i) { // quadrante ++
			if(temp[0] == false) {
				temp[0] = true;
				vect[0][0] = i;
				vect[0][1] = j;
			}
			else {
				array[vect[0][0]][vect[0][1]] = false;
				vect[0][0] = i;
				vect[0][1] = j;
			}
		}
		if (position.getColums()> j && position.getRow()>i  ) { // quadrante -+
			if(temp[1] == false) {
				temp[1] = true;
				vect[1][0] = i;
				vect[1][1] = j;
			}
			else {
				array[vect[1][0]][vect[1][1]] = false;
				vect[1][0] = i;
				vect[1][1] = j;
			}
		}
		
		if(position.getColums()>j && position.getRow()<i) { //quadrante --
			if(temp[2] == false) {
				temp[2] = true;
				vect[2][0] = i;
				vect[2][1] = j;
			}
			else {
				array[vect[2][0]][vect[2][1]] = false;
				vect[2][0] = i;
				vect[2][1] = j;
			}
		}
		
		if(position.getColums()<j && position.getRow()<i) { // quadrante +-
			if(temp[3] == false) {
				temp[3] = true;
				vect[3][0] = i;
				vect[3][1] = j;
			}
			else {
				array[vect[3][0]][vect[3][1]] = false;
				vect[3][0] = i;
				vect[3][1] = j;
			}
		}
	}
}
