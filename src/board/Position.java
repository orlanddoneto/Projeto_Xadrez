package board;

public class Position {
	private Integer row;
	private Integer colums;
	
	public Position(Integer row, Integer colums) {
		this.row = row;
		this.colums = colums;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColums() {
		return colums;
	}

	public void setColums(Integer colums) {
		this.colums = colums;
	}
	
	public void setValues(Integer row, Integer colums) {
		this.colums = colums;
		this.row = row;
	}
	
	@Override
	public String toString() {
		return row+", "+colums;
	}
	
	

}
