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
	
	private Field getField() {
	
		return this.field;
	}
	
	private void setField(Field field) {
		
		this.field = field;
	}
	
	public void printField() {
		
		Main.out.println("\n** Speelveld: " + this.getName() + " **");
		this.getField().print();
	}
	
	public void shootField(String target) {
		
		if(target.matches("[0-9]+[a-zA-Z]{1}")) {
			
			target = this.switchXY(target);
		}
		
		Square sq = this.getField().getMap().get(target);
		sq.setShot(true);
		
		//save shot
	}
	
	public boolean checkValidField(String target) {
		
		if(target.matches("[0-9]+[a-zA-Z]{1}")) {
		
			target = this.switchXY(target);
		}
		
		try {
			
			Square sq = this.getField().getMap().get(target);
			
			if(sq != null) {
			
				return true;
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {}
		
		return false;
	}
	
	private String switchXY(String target) {
		
		char x;
		
		if(target.length() == 2) {
			
			x = target.charAt(1);
		}
		
		else {
			
			x = target.charAt(2);
		}
		
		target = x + target.substring(0,2);
		
		Main.out.println("New target: " + target);
		
		return target;
	}
}
