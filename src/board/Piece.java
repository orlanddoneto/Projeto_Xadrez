package board;

public abstract class Piece {
	protected Position position;
	private BoardGame board;
	
	public Piece(BoardGame board) {
		position = null; //o jogo come�a considerando que as pe�as n�o est�o no tabuleiro
		this.board = board;
	}


	protected BoardGame getBoard() {
		return board;
	}

	//n�o h� setBoard, pois n�o se deve permitir que o tabuleiro seja alterado.
	
	public abstract boolean[][] possiblesMoves();
	
	public boolean possibleMove(Position pos) {
		return possiblesMoves()[pos.getRow()][pos.getColums()];
	}

	public boolean isTherePossibleMove(Position pos) {
		boolean [][] mat = possiblesMoves();
		for (int i = 0; i<mat.length;i++) {
			for (int j = 0; j<mat.length;j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
