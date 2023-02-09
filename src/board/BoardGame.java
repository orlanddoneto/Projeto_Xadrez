package board;

public class BoardGame {
	private Integer rows;
	private Integer colums;
	Piece[][] pieces;
	
	public BoardGame(Integer rows, Integer colums) {
		if (rows!=8 || colums!=8) {
			throw new BoardException("Número de linhas ou colunas inválido, pois o xadrez tem 64 casas.");
		}
		this.rows = rows;
		this.colums = colums;
		pieces = new Piece[rows][colums];
	}

	public Integer getRows() {
		return rows;
	}
	
	public Integer getColums() {
		return colums;
	}
	
	public Piece piece(Integer row, Integer colums) {
		if (!PositionExists(row,colums)) {
			throw new BoardException("Posição inexistente.");
		}
		return pieces[row][colums];
	}
	
	public Piece piece (Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Posição inexistente.");
		}
		return pieces[position.getRow()][position.getColums()];
	}
	
	public void PlacePiece(Piece piece,Position pos) {
		
		if (ThereIsAPiece(pos)) {
			throw new BoardException("Já existe uma peça na posição indicada!");
		}
		pieces[pos.getRow()][pos.getColums()] = piece;
		piece.position = pos;
	}
	
	public boolean PositionExists(int row, int colums) {
		return row>=0 && row<rows&& colums>=0 && colums<this.colums;
	}
	
	public boolean PositionExists(Position pos) {
		return PositionExists(pos.getRow(), pos.getColums());
		
	}
	
	public boolean ThereIsAPiece(Position pos) {
		if(!PositionExists(pos)) {
			throw new BoardException("A posição em questão não existe!");
		}
		return piece(pos)!= null;
	}
	
	public Piece RemovePiece(Position pos) {
		if (!PositionExists(pos)) {
			throw new BoardException("Posição inexistente"); 
		}
		
		if (piece(pos) == null) {
			return null; 
		}
		
		Piece temp = piece(pos);
		temp.position = null;
		pieces[pos.getRow()][pos.getColums()] = null;
		
		return temp;
	}
	

	
	
	
	//@Override
	//public String toString() {
		
		
	//	return sb.toString();
	//}
	
	
	
}
