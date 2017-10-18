package zeeslag;

public class SeaBattle {
	
	private Player player1;
	private Player player2;

	public SeaBattle(Player p1) {
		
		this.setPlayer1(p1);
	}
	
	public SeaBattle(Player p1, Player p2) {
		
		this.setPlayer1(p1);
		this.setPlayer2(p2);
	}

	public Player getPlayer1() {
		
		return player1;
	}

	public void setPlayer1(Player player1) {
		
		this.player1 = player1;
	}

	public Player getPlayer2() {
		
		return player2;
	}

	public void setPlayer2(Player player2) {
		
		this.player2 = player2;
	}
	
	private void printPlayers() {
		
		Main.out.println("\n**Spelers**");
		if(player1 != null) {
			
			Main.out.println("Speler 1: " + this.getPlayer1().getName());
		}
		
		if(player2 != null) {
			
			Main.out.println("Speler 2: " + this.getPlayer2().getName() + "\n");
		}
	}
	
	public void play() {
	
		this.printPlayers();
		
		if(this.getPlayer1() != null && this.getPlayer2() != null) {
			
		}
	}
}
