package zeeslag;

public class Player {
	
	private String name;
	private Field field;

	public Player (String name) {
		
		this.setName(name);
	}
	
	public String getName() {
		
		return this.name;
	}
	
	private void setName(String name) {
		
		if(!name.equals(null) || !name.isEmpty()) {
		
			this.name = name;
		}		
		else {
			
			Main.out.println("Ongeldige naam!");
		}
	}
	
	public Field getField() {
	
		return this.field;
	}
	
	public void setField() {
		
	}
}
