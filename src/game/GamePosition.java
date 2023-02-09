package game;

import board.Position;

public class GamePosition {
	private char columm;
	private Integer row;
	
	public GamePosition(char columm, Integer row) {
		if(columm<'a'||columm>'h'||row<1||row>8) {
			throw new GameException("Posição inválida.");
		}
		this.columm = columm;
		this.row = row;
	}
	
	
	public char getColumm() {
		return columm;
	}


	public Integer getRow() {
		return row;
	}

	
	public Position toPosition() {
		String columns = "abcdefgh";
		char [] vetor = columns.toCharArray();
		Integer colPos = null;
		for (int i=0;i<vetor.length;i++) {
			if (vetor[i] == columm) {
				colPos = i;
			}
		}
		return new Position(8-row,colPos);
	}
	
	public GamePosition fromPosition(Position pos) {
		String columns = "abcdefgh";
		char [] vetor = columns.toCharArray();
		char colPos = ' ';
		for (int i=0;i<vetor.length;i++) {
			if (pos.getColums() == i) {
				colPos = vetor[i];
			}
		}
		return new GamePosition(colPos, 8-pos.getRow());
	}
	
	public String toString() {
		return ""+ columm + row;
	}
}
