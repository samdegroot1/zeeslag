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
		
		return names;
	}
}
