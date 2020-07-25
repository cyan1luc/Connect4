import java.util.*;

public class Board {
	private int x, y, row, column;
	private char[][] board;
	protected char[] rows = {1, 2, 3, 4, 5, 6, 7};
	protected int[] columns = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
	Scanner keyboard = new Scanner(System.in);
	
	public Board(){
		this.x = rows.length;
		this.y = columns.length;
		board = new char[x][y];
		createBoard();
		printBoard();
	}
	public Board(int i, int j){
		this.x = rows.length;
		this.y = columns.length;
		board = new char[x][y];
		createBoard();
		board[i][j+3] = 'O';
		board[i+1][j+2] = 'O';
		board[i+2][j+1] = 'O';
		board[i+3][j] = 'O';
		printBoard();
	}
	
	public void createBoard(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				board[i][j] = '_';
			}
		}
	}
	
	public void printBoard(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	public char checkSpace(int i, int j){
		return board[i][j];
	}
	
	public void getRow(int row){
		this.row = row;
	}
	public void getColumn(int column){
		this.column = column;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	
	public void setBoardSpace(char change){
		playerInput(keyboard.nextInt());
		board[row][column] = change;
		System.out.println("passed");
	}
	
	public void playerInput(int kcolumn){
		if(kcolumn < 0 || kcolumn > 6){
			System.out.println("Dormamu, I've come to bargain!");
			System.out.println("That's an invalid column, try again.");
			playerInput(keyboard.nextInt());
		} else{
			row = 6;
			this.column = kcolumn;
			while(board[row][column] != '_'){
				row--;
				if(row < 0){
					System.out.println("Dormamu, I've come to bargain!");
					System.out.println("Column : " + getColumn() + " is full, please pick another.");
					playerInput(keyboard.nextInt());
				}
			}
		}
	}
}
