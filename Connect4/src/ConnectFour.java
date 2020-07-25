import java.util.*;


public class ConnectFour {
	
	Board board;
	Player p1, p2, current, winner;
	int turn = 1;
	Scanner keyboard = new Scanner(System.in);
	
	public ConnectFour(Board board, Player p1, Player p2, Player current, Player winner){
		this.board = board;
		this.p1 = p1;
		this.p2 = p2;
		this.current = p2;
		this.winner = winner;
	}
	
	public ConnectFour(Board board, Player p1, Player p2, Player current){
		this.board = board;
		this.p1 = p1;
		this.p2 = p2;
		this.current = p2;
	}
	
	public ConnectFour(Board board, Player p1, Player p2){
		this.board = board;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void switchPlayer(){
		System.out.println(current.getName());
		if(current == p1){
			current = p2;
			System.out.println(current.getName() + ": " + current.getMove());
		} else if(current == p2){
			current = p1;
			System.out.println(current.getName() + ": " + current.getMove());
		}
	}
	
	public void playConnectFour(){
		while(winner == null && (turn < board.rows.length * board.columns.length)){
			System.out.println("");
			switchPlayer();
			board.setBoardSpace(current.getMove());
			winner = winCondition();
			board.printBoard();
			turn++;
		}
//		switchPlayer();
//		board.setBoardSpace(current.getMove());
//		winner = winCondition();
//		board.printBoard();
	}
	
	public Player winCondition(){
		if(checkRows() != null || checkColumns() != null || checkDiagonalLeft() != null || checkDiagonalRight() != null){
			System.out.println(winner.getName() + " wins");
			return winner;
		}
		return winner;
	}
	
	public Player checkRows(){
		for(int i = 0; i < board.rows.length; i++){
			for(int j = 0; j < board.columns.length - 3; j++){
				Set<Character> pieceSet = new HashSet<>();
				pieceSet.add(board.checkSpace(i, j));
				pieceSet.add(board.checkSpace(i, j+1));
				pieceSet.add(board.checkSpace(i, j+2));
				pieceSet.add(board.checkSpace(i, j+3));
				if(pieceSet.size() == 1){						//Set is a collection so copies are not allowed
					if(pieceSet.contains(current.getMove())){	//That means size must be one to check winner
						winner = current;
					}
				}
			}
		}
		System.out.println("rows win");
		return winner;
	}
	
	public Player checkColumns(){
		for(int i = 0; i < board.rows.length - 3; i++){
			for(int j = 0; j < board.columns.length; j++){
				Set<Character> pieceSet = new HashSet<>();
				pieceSet.add(board.checkSpace(i, j));
				pieceSet.add(board.checkSpace(i+1, j));
				pieceSet.add(board.checkSpace(i+2, j));
				pieceSet.add(board.checkSpace(i+3, j));
				if(pieceSet.size() == 1){						//Set is a collection so copies are not allowed
					if(pieceSet.contains(current.getMove())){	//That means size must be one to check winner
						winner = current;
					}
				}
			}
		}
		System.out.println("columns win");
		return winner;
	}
	
	public Player checkDiagonalRight(){
		for(int i = 0; i < board.rows.length - 3; i++){
			for(int j = 0; j < board.columns.length - 3; j++){
				Set<Character> pieceSet = new HashSet<>();
				pieceSet.add(board.checkSpace(i, j));
				pieceSet.add(board.checkSpace(i+1, j + 1));
				pieceSet.add(board.checkSpace(i+2, j + 2));
				pieceSet.add(board.checkSpace(i+3, j + 3));
				if(pieceSet.size() == 1){						//Set is a collection so copies are not allowed
					if(pieceSet.contains(current.getMove())){	//That means size must be one to check winner
						winner = current;
					}
				}
			}
		}
		return winner;
	}
	
	public Player checkDiagonalLeft(){
		for(int i = 0; i < board.rows.length-3; i++){
			for(int j = 0; j < board.columns.length-3; j++){
				Set<Character> pieceSet = new HashSet<>();
				pieceSet.add(board.checkSpace(i, j+3));
				pieceSet.add(board.checkSpace(i+1, j + 2));
				pieceSet.add(board.checkSpace(i+2, j + 1));
				pieceSet.add(board.checkSpace(i+3, j));
				if(pieceSet.size() == 1){						//Set is a collection so copies are not allowed
					if(pieceSet.contains(current.getMove())){	//That means size must be one to check winner
						winner = current;
					}
				}
			}
		}
		return winner;
	}
	
	public static void main(String [] args){
		Player p1 = new Player('X');
		Player p2 = new Player('O');
		Player current = new Player();
		Player winner = null;
		Board board = new Board();
		ConnectFour C4 = new ConnectFour(board, p1, p2, current, winner);
		C4.playConnectFour();
	}
}
