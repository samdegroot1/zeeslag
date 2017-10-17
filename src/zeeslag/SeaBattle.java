package zeeslag;

public class SeaBattle {
	
	private Player player1;
	private Player player2;

	public SeaBattle() {
		
		this.printIntro();
		int amount = this.askPlayers();
		
		if(amount == 1) {
			
			player1 = new Player();
			player2 = new Player();
			
			player1.setName(player1.askPlayerName(1));
		}
		
		else {
			
			player1 = new Player();
			player2 = new Player();
			
			player1.setName(player1.askPlayerName(1));
			player2.setName(player2.askPlayerName(2));
		}
	}
	
	public void printIntro() {
		
		Main.out.println("Welkom bij het spelletje Zeeslag!");
		Main.out.println("Probeer de oorlogsbodems van je tegenstander tot zinken te brengen");
		Main.out.println("voor hij jouw boten te pakken heeft genomen. \n");
	}
	
	public int askPlayers() {
		
		Main.out.print("Geef aantal spelers (1/2):");
		
		int amount = Main.in.nextInt();
		
		if(amount <= 0 || amount >= 3) {
			
			Main.out.println("** Dat is geen geldig aantal spelers! **\n");
			
			askPlayers();
		}
		
		return amount;
	}
}
