package zeeslag;

public class Player {
	
	private String name;

	public Player () {
		
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String name) {
		
		if(!name.equals(null) || !name.isEmpty()) {
		
			this.name = name;
		}		
		else {
			
			Main.out.println("Ongeldige naam!");
		}
	}
	
	public String askPlayerName(int number) {
		
		if(number == 1) {
			
			Main.out.print("Wat is de naam van speler 1?: ");
		}
		
		else {
			Main.out.print("Wat is de naam van speler 2?: ");
		}
		
		String name = Main.in.next();
		
		return name;
	}
}
