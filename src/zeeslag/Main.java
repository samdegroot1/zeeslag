package zeeslag;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	public static final Scanner in = new Scanner(System.in);
	public static final PrintStream out = System.out;
	public static final boolean cheat = false;

	public static void main(String[] args) {
		
		Main.out.println("Welkom bij het spelletje Zeeslag!");
		Main.out.println("Probeer de oorlogsbodems van je tegenstander tot zinken te brengen");
		Main.out.println("voor hij jouw boten te pakken heeft genomen. \n");
		
		SeaBattle game = new SeaBattle();		
	}
}
