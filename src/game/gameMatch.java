package game;

import board.BoardException;
import board.BoardGame;
import board.Piece;
import board.Position;
import chess_pieces.Bishop;
import chess_pieces.Horse;
import chess_pieces.King;
import chess_pieces.Pawn;
import chess_pieces.Queen;
import chess_pieces.Rook;

public class gameMatch {
	private BoardGame board;
	
	public gameMatch() {
		board = new BoardGame(8,8);
		initialSetup();
	}
	
	public GamePiece[][] getPieces() {
		GamePiece[][]matChess = new GamePiece[board.getRows()][board.getColums()];
		for (int i = 0; i<board.getRows();i++) {
			for (int j=0;j<board.getColums();j++) {
				matChess [i][j] = (GamePiece) board.piece(i, j);
			}
		}
		return matChess;
	}
	
	private void placeNewPiece(char columm, int row, GamePiece piece) {
		board.PlacePiece(piece, new GamePosition(columm, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('a',8,new Rook(board,Color.BLACK));
		placeNewPiece('b',8,new Horse(board,Color.BLACK));
		placeNewPiece('c',8,new Bishop(board,Color.BLACK));
		placeNewPiece('d',8,new King(board,Color.BLACK));
		placeNewPiece('e',8,new Queen(board,Color.BLACK));
		placeNewPiece('f',8,new Bishop(board,Color.BLACK));
		placeNewPiece('g',8,new Horse(board,Color.BLACK));
		placeNewPiece('h',8,new Rook(board,Color.BLACK));
		
		//for para o peão
		String colunas = "abcdefgh";
		char [] vect = colunas.toCharArray();
		for (char elm:vect) {
			placeNewPiece(elm, 7, new Pawn(board, Color.BLACK));
		}
		
		
		placeNewPiece('a',1,new Rook(board,Color.WHITE));
		placeNewPiece('b',1,new Horse(board,Color.WHITE));
		placeNewPiece('c',1,new Bishop(board,Color.WHITE));
		placeNewPiece('d',1,new Queen(board,Color.WHITE));
		placeNewPiece('e',1,new King(board,Color.WHITE));
		placeNewPiece('f',1,new Bishop(board,Color.WHITE));
		placeNewPiece('g',1,new Horse(board,Color.WHITE));
		placeNewPiece('h',1,new Rook(board,Color.WHITE));
		
		//for para o peão
		String colunas2 = "abcdefgh";
		char [] vect2 = colunas.toCharArray();
		for (char elm:vect) {
			placeNewPiece(elm, 2, new Pawn(board, Color.WHITE));
		}
	}
	
	public GamePiece movePiece (GamePosition iniPos,GamePosition finalPos ) {
		validatePosition(iniPos.toPosition());
		//Verificar se o movimento é válido.
		Piece PieceAux1 = board.RemovePiece(iniPos.toPosition());
		Piece PieceAux2 = board.RemovePiece(finalPos.toPosition());
		board.PlacePiece(PieceAux1, finalPos.toPosition());
		return (GamePiece)PieceAux2;
	}
	
	public boolean[][] possibleMoves(GamePosition pos) {
		Position position = pos.toPosition();
		
		validatePosition(position);
		return board.piece(position).possiblesMoves();
	}
	
	public void validatePosition(Position pos) {
		if (!board.ThereIsAPiece(pos)) {
			throw new GameException("Não há uma peça nessa posição.");
		}
		
		if(!board.piece(pos).isTherePossibleMove(pos)) {
			throw new GameException("Não há movimentos possíveis.");
		}
	}
}
