/**
	@class: InitializeGame	
	@desciption: Class is used to handle some game initialization.
	The code written here is seperated from the rest of the classes to keep things clean and seperated from eachother.
	
	@author Sam de Groot
	@version 1.0
*/

package zeeslag;

public class InitializeGame {
	
	private int playerAmount;
	
	private int getPlayerAmount() {
		
		return this.playerAmount;
	}
	
	private void setPlayerAmount(int amount) {
		
		if(amount < 1 || amount > 2) {
			
			Main.out.println("** Dat is geen geldig aantal spelers! **\n");
			this.askPlayerAmount();
		}
		
		else {
			this.playerAmount = amount;
		}
	}
		
	/**
		@method: askPlayerAmount()
		@desciprion: Asking the player with how many players to play.
		
		@return int amount of players.
	*/
	public void askPlayerAmount() {
		
		int amount = 0;
		Main.out.print("Geef aantal spelers (1/2): ");		
		
		try {
		
			amount = Integer.parseInt(Main.in.nextLine());
		}		
		catch(Exception e) {}
				
		
		this.setPlayerAmount(amount);		
	}

	/**
		@method: printIntro()
		@description: Print intro message at the start of the game.
	 */
	public void printIntro() {
		
		Main.out.println("Welkom bij het spelletje Zeeslag!\n");
		Main.out.println("Probeer de oorlogsbodems van je tegenstander tot zinken te brengen");
		Main.out.println("voor hij jouw boten te pakken heeft genomen. \n");
	}
	
	/**
		@method: askPlayerNames()
		@Description: Depending on the amount players given. Asking their names.
		
		@return String[] amount of players.
	 */
	public String[] askPlayerNames() {
		
		String[] names;
		
		if(this.getPlayerAmount() == 1) {
			
			names = new String[1];
			
			Main.out.print("Wat is je naam?: ");			
			names[0] = Main.in.nextLine();
		}
		
		else {
			
			names = new String[2];
			
			Main.out.print("Wat is de naam van speler 1?: ");			
			names[0] = Main.in.nextLine();
			
			Main.out.print("Wat is de naam van speler 2?: ");			
			names[1] = Main.in.nextLine();
		}
		
		Main.out.print("\n");
		
		return names;
	}
}
