package zeeslag;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	public static final Scanner in = new Scanner(System.in);
	public static final PrintStream out = System.out;
	public static final boolean cheat = false;

	public static void main(String[] args) {		
		
		SeaBattle game = new SeaBattle();
		game.printIntro();
		game.askPlayers();
	}
}
