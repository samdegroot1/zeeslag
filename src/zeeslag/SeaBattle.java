/**
	@class: SeaBattle	
	@desciption: This class handles the playturns for singleplayer and multiplayer; which player's turn it is and interacting with the player
	Also handles game progress like who's the winner and asks to play again.
	
	@author Sam de Groot
	@version 1.0
*/

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
	
	/**
 		@method: rollStartingPlayer()
 		@description: Based on a random number the starting player is picked.
 		it switches player1 with player2 if necessary. So the battle always starts with player1.
 		(Which could be p2 in the first place)
	 */
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
	
	/**
 		@method: playSinglePlayer()
 		@description: 1 player is given. This function handles singleplayer logic to keep the game runnin until a player wins.
 		When the player wants to play again the field will get a reset and the game restarts here.
	 */
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
	
	/**
		@method: playMultiPlayer()
		@description: 2 players given. This function handles multiplayer logic to keep the game running until a player wins.
		When the players wants to play again the fields get a reset and the game restarts here.
	 */
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
	
	/**
		@method: playTurn()
		@description: 2 players given. This function handles multiplayer logic to keep the game running until a player wins.
		When the players wants to play again the fields get a reset and the game restarts here.
		
		@param Player player: This variable contains the player whose turn it is to play.
		@param boolean retry: This variable is true when the player gave a invalid field. This prevents the playfield to be printed again. 
		Which improves readability.
	 */
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
	
	/**
 		@method: askPlayAgain()
 		@description: A player won. Ask if they wanna play again.
 		
 		@return boolean;
	 */
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
