/**
	@class: Player	
	@desciption: Class handles user input where they wanna shoot. Print their playfield and victory handling.
	
	@author Sam de Groot
	@version 1.0
*/
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
	
	/**
 		@method: printField()
 		@description: Prints the playfield in the console
	 */
	public void printField() {
		
		Main.out.println("\n** Speelveld: " + this.getName() + " **");
		this.getField().print();
	}
	
	/**
 		@method: shoot()
 		@description: This function is called when the user gave a target to shoot a square.
 		
 		@param String target: the variable contains the key (coordinate) which square he wants to shoot.
	 */
	public void shoot(String target) {
		
		this.getField().shootField(target);
	}
	
	/**
 		@method: checkVictory()
 		@description: Every time a player shot a field, this function checks if all the boats are down on the field.
 		In cheat mode the player wins after 1 boat down.
 		
 		@return boolean: True if player wins, else false.
	 */
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
	
	/**
 		@method: resetField()
 		@description: When the player(s) want to play again this function is called to reset their playfields.
	 */
	public void resetField() {
		
		this.setField(new Field());
	}
}
