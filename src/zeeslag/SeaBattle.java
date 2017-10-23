package zeeslag;

import java.util.Random;

public class SeaBattle {
	
	private Player player1;
	private Player player2;
	private boolean singlePlayer = true;
	private boolean playing = true;

	public SeaBattle(Player p1) {
		
		this.setPlayer1(p1);
	}
	
	public SeaBattle(Player p1, Player p2) {
		
		this.setPlayer1(p1);
		this.setPlayer2(p2);
		this.setSinglePlayer(false);
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
	
	private void setSinglePlayer(boolean mode) {
		
		this.singlePlayer = mode;
	}
	
	private boolean getSinglePlayer() {
		
		return this.singlePlayer;
	}
	
	private void setPlaying(boolean mode) {
		
		this.playing = mode;
	}
	
	private boolean getPlaying() {
		
		return this.playing;
	}
	
	public void play() {
		
		if(this.getSinglePlayer()) {
					
			this.playSinglePlayer();
		}
		
		else {
			this.rollStartingPlayer();
			this.playMultiPlayer();
		}
	}
	
	
	private void rollStartingPlayer() {
		
		Random rand = new Random();
		
		int n = rand.nextInt(2) + 1;
		
		if(n == 1) {
			
			Main.out.println(this.getPlayer1().getName() + " mag beginnen!\n");
		}
		else {
			
			Main.out.println(this.getPlayer2().getName() + " mag beginnen!\n");
			
			Player dummyPlayer = this.getPlayer1();
			
			this.setPlayer1(this.getPlayer2());
			this.setPlayer2(dummyPlayer);
		}
	}
	
	private void playSinglePlayer() {
		
		while(this.getPlaying()) {
			
			this.playTurn(this.getPlayer1(), false);
		}
		
		if(this.askPlayAgain()) {
			
			this.getPlayer1().resetField();
			this.setPlaying(true);
			this.playSinglePlayer();
		}
	}
	
	private void playMultiPlayer() {
		
		int currentPlayer = 1;
		
		while(this.getPlaying()) {
			
			if(currentPlayer == 1) {
				
				Main.out.println("**" + this.getPlayer1().getName() + " is aan de beurt! **");
				this.playTurn(this.getPlayer1(), false);
				currentPlayer = 2;
			}			
			else {
				Main.out.println("**" + this.getPlayer2().getName() + " is aan de beurt! **");
				this.playTurn(this.getPlayer2(), false);
				currentPlayer = 1;
			}
		}
		
		if(this.askPlayAgain()) {
			
			this.getPlayer1().resetField();
			this.getPlayer2().resetField();
			this.setPlaying(true);
			this.playMultiPlayer();
		}
	}
	
	private void playTurn(Player player, boolean retry) {
				
		if(!retry) {
			
			player.printField();
		}
		
		Main.out.print(player.getName()+ ", geef de locatie die je wilt beschieten:");
		
		String target = Main.in.nextLine().toUpperCase();
		
		if(player.getField().checkValidField(target)) {
			
			player.shoot(target);
		} 
		else {
			
			Main.out.println("Dit is geen geldige locatie!\n ");
			this.playTurn(player, true);
		}
		
		if(player.checkVictory()) {
			
			this.setPlaying(false);
		}
	}
	
	private boolean askPlayAgain() {
		
		Main.out.println("Spel opnieuw spelen? (ja/nee)");
		
		String answer = Main.in.nextLine().toLowerCase().trim();
		
		if(answer.equals("ja")) {
			
			return true;
		}
		
		if(answer.equals("nee")) {
			
			Main.out.println("\nBedankt voor het spelen!");			
			System.exit(0);
		}
		
		else {
			
			Main.out.println("Ongeldige invoer! \n");
			this.askPlayAgain();
		}
		
		return false;
 	}
}
