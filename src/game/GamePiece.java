package game;

import board.BoardGame;
import board.Piece;
import board.Position;

public abstract class GamePiece extends Piece {
	private Color color;
	private Integer moveCount;
	
	public GamePiece(BoardGame board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public Integer getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(Integer moveCount) {
		this.moveCount = moveCount;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		GamePiece p = (GamePiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
	
}
