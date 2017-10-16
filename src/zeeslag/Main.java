package zeeslag;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	public static final Scanner in = new Scanner(System.in);
	public static final PrintStream out = System.out;
	public static final boolean cheat = false;

	public static void main(String[] args) {		
		
		SeaBattle game = new SeaBattle(askPlayers());
	}
	
	public static int askPlayers() {
		
		Main.out.print("Geef aantal spelers (1/2):");
		
		int amount = in.nextInt();
		
		if(amount <= 0 || amount >= 3) {
			
			Main.out.println("** Dat is geen geldig aantal spelers! **\n");
			
			askPlayers();
		}
		
		return amount;
	}
}
