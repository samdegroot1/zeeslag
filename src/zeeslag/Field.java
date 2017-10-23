/**
	@class: Field	
	@desciption: Generating the printfield for the player(s).
	Printing/updating the field and ships on the field.
	
	@author Sam de Groot
	@version 1.0
*/

package zeeslag;

import java.util.HashMap;
import java.util.Random;

public class Field {

	private HashMap <String, Square> map;
	private HashMap <String, Ship> ships;
	private int sunkShips;
	
	public Field() {
		
		this.setMap(new HashMap<String, Square>());
		this.generateField();
		this.makeShips();
	}
	
	public HashMap<String, Square> getMap() {
		
		return this.map;
	}
	
	private void setMap(HashMap<String, Square> map) {
		
		this.map = map;
	}
	
	private void setShips(HashMap<String, Ship> ships) {
		
		this.ships = ships;
	}
	
	private HashMap<String, Ship> getShips() {
		
		return this.ships;
	}
	
	public int getSunkShips() {
	
		return this.sunkShips;
	}
	
	private void setSunkShips(int number) {
		
		this.sunkShips = number;
	}
	
	/**
		@method: generateField()
		@description: Generating the playfield using 2 loops. 
		Indexes of the loops are used to make a unique key for that square on the field.
	*/
	private  void generateField() {
		
		for(int i=0; i < 11; i++) {
			
			for(char a = 'A'; a < 'K'; a++) {
				
				map.put(a+""+i, new Square());				
			}	
		}
	}
	
	/**
		@method: makeShips()
		@desciption: Making 5 different ships. Each with their own key.
		Placing each ship on the field when made.
	*/
	private void makeShips() {
		
		HashMap<String, Ship> ships = new HashMap<String ,Ship>();
		
		ships.put("aircraftCarrier", new Ship(1));
		ships.put("battleShip", new Ship(2));
		ships.put("subMarine", new Ship(3));
		ships.put("destroyer", new Ship(4));
		ships.put("patrolBoat", new Ship(5));
		
		this.setShips(ships);
		
		for(String key : this.getShips().keySet()) {
			
			this.placeShip(this.getShips().get(key));
		}
	}
	
	/**
		@method: placeShip()
		@description: Placing a ship on a available position in a certain direction with the length of the ship.
		Before the ship is placed checkPositions() checks if the boat can be placed in that direction.
		After 4 failing tries (directions) the function calls itself again with the same ship to try again with a new random key.
		
		@param Ship ship: The ship to be placed on the field.
	*/
	private void placeShip(Ship ship) {
		
		String key = this.generateRandomKey();
		Random rand = new Random();
		
		int counter = 0;
		boolean posFound = false;
		String[] directions = {"right", "left", "up", "down"};
		String[] result = null;
		
		
		while(posFound == false) {
			
			String testDirection = directions[rand.nextInt(3) + 0];
			
			result = this.checkPositions(key, testDirection, ship.getSize());
			
			if(result != null) {
				
				posFound = true;
				break;
			}
			
			if(result == null && counter == 4) {
			
				this.placeShip(ship);
				break;
			}
			
			counter++;
		}
		
		if(posFound == true && !result.equals(null)) {
			
			if(Main.debug) {
			
				Main.out.println("Schip " + ship.getName() + " is mogelijk te plaatsen!");
			}			
			
			String name = ship.getName().substring(0, 1);
			
			for(int i=0; i < ship.getSize(); i++) {
												
				if(Main.debug) {
					
					Main.out.println("Length: " + ship.getSize() + " index: " + i + " key: " + result[i]);
				}
				
				this.getMap().get(result[i]).setShip(name);
				this.getMap().get(result[i]).setShipType(ship.getShipType());
			}
		}
	}
	
	/**
		@method: checkPositions()
		@description: In combination with the random key of a Square, direction and length of the boat.
		This function looks that all the squares in that direction are empty. If not it returns null.
		
		@param String key: Unique key of the starting square.
		@param String direction: Contains the direction the boat will be laying at.
		@param int Length: The length of the boat. In other words; how many space there is needed.
		
		@return String[] squares: This array contains keys where it is possible to place the boat. Null if not possible.
	*/
	private String[] checkPositions (String key, String direction, int length) {
		
		char x = key.charAt(0);
		int y = Integer.parseInt(key.substring(1, 2));
		int remainingSquares = length;
		String[] squares = new String[length];
		
			
		for(int i=0; i < length; i++) {
			
			if(x >= 'A' && x < 'K' && y >= 0 && y < 11) {
				
				try {
					
					if(Main.debug) {
					
						Main.out.println("Key: " + x+""+y);
					}					
					
					String sq = this.getMap().get(x+""+y).getShip();
					
					if(sq.equals("none")) {
						
						remainingSquares--;
						squares[i] = x+""+y;
					}
				}
				catch(ArrayIndexOutOfBoundsException exception) {}
				
				switch(direction) {
				
					case "right":
						x++;
					break;
					case "left":
						x--;
					break;
					case "up":
						y++;
					break;
					case "down":
						y--;
					break;
				}				
			}												
		}
		
		if(remainingSquares == 0) {
			
			return squares;
		}		
		else {
			
			return null;
		}
	}
	
	/**
 		@method: generateRandomKey()
 		@description: Generates a random key in the range of which the playfield is being played (1-10) & (A-J).
 		
 		@return String: In the format of a key like "C3".
	 */
	private String generateRandomKey() {
		
		Random rand = new Random();		
		String characters = "ABCDEFGHIJ";
		int randChar = rand.nextInt(9) + 0;
		
		int y = rand.nextInt(10) + 1;
		char x = characters.charAt(randChar);
		
		return x+""+y;
	}
	
	/**
 		@method: print()
 		@description: This function prints the playfield of a player. Output is different on the state of the square.
	 */
	public void print() {
		
		for(int i=10; i >= 1; i--) {
						
			if(i < 10) {
				
				Main.out.print(" " + i);
			} 
			else {
				Main.out.print(i);
			}
			
			for(char a = 'A'; a < 'K'; a++) {
				
				Square square = this.getMap().get(a+""+i);
				Ship ship = this.getShipByType(square.getShipType());
				
			
				if(square.isShot() && square.getShip() != "none" && ship.getDestroyed()) {
					
					Main.out.print(square.getShip());
				}
				if(square.isShot() && square.getShip() != "none" && !ship.getDestroyed()) {
					
					Main.out.print("*");
				}
				
				if(square.isShot() && square.getShip() == "none") {
					
					Main.out.print("~");
				}
				
				if(!square.isShot()) {
					
					Main.out.print(".");
				}
			}
			
			Main.out.print("\n");
		}
		
		Main.out.println("  ABCDEFGHIJ\n");
		
		if(Main.cheat) {
			
			this.cheatPrint();
		}
	}
	
	/**
 		@method: cheatPrint()
 		@description: If cheat mode is enabled, a extra copy of the playfield is printed which exposes the boats positions.
	 */
	private void cheatPrint() {
		
		System.out.println("** CHEAT **");
			
		for(int i=10; i >= 1; i--) {
						
			if(i < 10) {
				
				Main.out.print(" " + i);
			} 
			else {
				Main.out.print(i);
			}
			
			for(char a = 'A'; a < 'K'; a++) {
				
				Square square = this.getMap().get(a+""+i);
				
				if(!square.getShip().equals("none")) {
					
					Main.out.print(square.getShip());
				}
				
				else {
					
					Main.out.print(".");
				}
			}
			
			Main.out.print("\n");
		}
		
		Main.out.println("  ABCDEFGHIJ\n");
	}
	
	/**
 		@method: checkValidField()
 		@description: Checks if the user's given target is a valid in the range of the playfield.
 		
 		@param String target: Contains the user's input target.
 		@return boolean: True if target is square, else false.
	 */
	public boolean checkValidField(String target) {
		
		if(target.matches("[0-9]+[a-zA-Z]{1}")) {
		
			target = this.switchXY(target);
		}
		
		try {
			
			Square sq = this.getMap().get(target);
			
			if(sq != null) {
			
				return true;
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {}
		
		return false;
	}
	
	/**
 		@method: shootField()
 		@description: Shoots the field, if the field contains a ship a hit is added to that field.
 		
 		@param String target: User's given target.
	 */
	public void shootField(String target) {
		
		if(target.matches("[0-9]+[a-zA-Z]{1}")) {
			
			target = this.switchXY(target);
		}
		
		Square square = this.getMap().get(target);
		Ship ship = this.getShipByType(square.getShipType());
		
		square.setShot(true);
		
		if(ship != null) {
		
			ship.addShotHit();			
			
			if(ship.getDestroyed()) {
				
				this.addSunkShip();
			}
		}		
	}
	
	/**
 		@method: switchXY()
 		@description: If the user gives a target like 10B this function converts the target to B10.
 		
 		@return String: Reformatted target.
	 */
	private String switchXY(String target) {
		
		char x;
		
		if(target.length() == 2) {
			
			x = target.charAt(1);
			target = x + target.substring(0,1);
		}
		else {
			
			x = target.charAt(2);
			target = x + target.substring(0,2);
		}
		
		if(Main.debug) {
			
			Main.out.println("Returned new target: " + target);
		}
				
		return target;
	}
	
	/**
 		@method: getShipBy()
 		@description: Function to return a ship by it's type instead of his name. To improve handling with the boats.
 		
 		@param int type: Integer identifying the ship by it's type.
 		@return Ship: Ship matching with the given type.
	 */
	private Ship getShipByType(int type) {
			
		switch(type) {
		
			case 1:
				return this.getShips().get("aircraftCarrier");

			case 2:
				return this.getShips().get("battleShip");

			case 3:
				return this.getShips().get("subMarine");

			case 4:
				return this.getShips().get("destroyer");

			case 5:
				return this.getShips().get("patrolBoat");
		}
		
		return null;
	}
	
	/**
 		@method: addSunkShip()
 		@description: The targeted ship is destroyed so the counter for sunk ships has to be increased.
	 */
	private void addSunkShip() {
		
		int sunkShips = this.getSunkShips() + 1;
		this.setSunkShips(sunkShips);
	}
}
