package zeeslag;

public class Player {
	
	private String name;

	public Player (String name) {
		
		this.setName(name);
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
}
