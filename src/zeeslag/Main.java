package zeeslag;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	public static final Scanner in = new Scanner(System.in);
	public static final PrintStream out = System.out;
	public static final boolean cheat = false;

	public static void main(String[] args) {
		
		InitializeGame init = new InitializeGame();
		SeaBattle game;
		
		init.printIntro();
		init.askPlayerAmount();
		
		String[] names = init.askPlayerNames();
		
		if(names.length == 1) {
			
			game = new SeaBattle(names[0]);
		} 
		else {
			
			game = new SeaBattle(names[0], names[1]);
		}
		
		game.printPlayers();
	}
}
