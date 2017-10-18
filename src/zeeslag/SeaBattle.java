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
		
	}
	
	private void playMultiPlayer() {
		
		int currentPlayer = 1;
		
		while(this.getPlaying()) {
			
			if(currentPlayer == 1) {
				
				Main.out.println("**" + this.getPlayer1().getName() + " is aan de beurt! **");
				this.getPlayer1().printField();
				break;
			}			
			else {
				Main.out.println("**" + this.getPlayer2().getName() + " is aan de beurt! **");
				this.getPlayer2().printField();
				break;
			}
		}
	}
}
