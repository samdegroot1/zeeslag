package zeeslag;

public class Player {
	
	private String name;
	private Field field;

	public Player (String name) {
		
		this.setName(name);
		this.setField(new Field());
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
	
	private void setField(Field field) {
		
		this.field = field;
	}
	
	public void printField() {
		
		Main.out.println("\n** Speelveld: " + this.getName() + " **");
		this.getField().print();
	}
	
	public void shoot(String target) {
		
		this.getField().shootField(target);
	}
	
	public boolean checkVictory() {
	
		if(this.getField().getSunkShips() == 5) {
			
			Main.out.println(this.getName() + " heeft het spel gewonnen!");
			
			return true;
		}
		
		if(this.getField().getSunkShips() == 1 && Main.cheat) {
			
			Main.out.println(this.getName() + " heeft het spel in cheat modus gewonnen!");
			
			return true;
		}
		
		return false;
	}
	
	public void resetField() {
		
		this.setField(new Field());
	}
}
