package zeeslag;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	public static final Scanner in = new Scanner(System.in);
	public static final PrintStream out = System.out;
	public static final boolean cheat = true;
	public static final boolean debug = false;

	public static void main(String[] args) {
		
		InitializeGame init = new InitializeGame();
		SeaBattle game;
		
		init.printIntro();
		init.askPlayerAmount();
		
		String[] names = init.askPlayerNames();
		
		if(names.length == 1) {
			
			Player player1 = new Player(names[0]);
			
			game = new SeaBattle(player1);
		} 
		else {
			
			Player player1 = new Player(names[0]);
			Player player2 = new Player(names[1]);
			
			game = new SeaBattle(player1, player2);
		}
		
		game.play();
	}
}
