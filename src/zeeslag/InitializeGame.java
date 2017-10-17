package zeeslag;


public class InitializeGame {

	public void printIntro() {
		
		Main.out.println("Welkom bij het spelletje Zeeslag!\n");
		Main.out.println("Probeer de oorlogsbodems van je tegenstander tot zinken te brengen");
		Main.out.println("voor hij jouw boten te pakken heeft genomen. \n");
	}
	
	public int getPlayerAmount() {
		
		Main.out.print("Geef aantal spelers (1/2): ");
		
		int amount = 0;
		
		if(Main.in.hasNextInt()) {
			
			amount = Main.in.nextInt();
			
			Main.out.println(amount);
		} 
		else {
			Main.out.println("** Geef een getal! **\n");
			this.getPlayerAmount();
		}
				
		if(amount != 1 || amount != 2) {
			
			Main.out.println("** Dat is geen geldig aantal spelers! **\n");
			this.getPlayerAmount();		
		}
		
		return amount;
	}
}
