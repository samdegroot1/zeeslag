package zeeslag;


public class InitializeGame {
	
	private int playerAmount;
	
	public int getPlayerAmount() {
		
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
	
	public void askPlayerAmount() {
		
		Main.out.print("Geef aantal spelers (1/2): ");
			
		int amount = Integer.parseInt(Main.in.nextLine());		
		
		this.setPlayerAmount(amount);		
	}

	public void printIntro() {
		
		Main.out.println("Welkom bij het spelletje Zeeslag!\n");
		Main.out.println("Probeer de oorlogsbodems van je tegenstander tot zinken te brengen");
		Main.out.println("voor hij jouw boten te pakken heeft genomen. \n");
	}
}
