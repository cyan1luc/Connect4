import java.util.*;

public class Player {
	Scanner keyboard = new Scanner(System.in);
	private String name;
	private char move;
	
	public Player(){
		
	}
	
	public Player(char move){
		this.move = move;
		System.out.println("Please enter your name, you will be: " + move);
		setName(keyboard.nextLine());
		System.out.println("Welcome: " + getName() + ", you are: " + getMove());
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setMove(char move){
		this.move = move;
	}
	
	public char getMove(){
		return move;
	}
}
