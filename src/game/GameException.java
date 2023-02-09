package game;

import board.BoardException;

public class GameException extends BoardException {
	public GameException(String msg) {
		super(msg);
	}
}
