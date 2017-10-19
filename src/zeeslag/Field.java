package zeeslag;

import java.util.HashMap;
import java.util.Random;

public class Field {

	private HashMap <String, Square> map;
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
	
	public int getSunkShips() {
	
		return this.sunkShips;
	}
	
	public void setSunkShips(int number) {
		
		this.sunkShips = number;
	}
	
	private  void generateField() {
		
		for(int i=0; i < 11; i++) {
			
			for(char a = 'A'; a < 'K'; a++) {
			
				map.put(a+""+i, new Square());
			}			
		}
	}
	
	private void makeShips() {
		
		HashMap <String, Ship> ships = new HashMap();
		
		ships.put("aircraftCarrier", new Ship(1));
		ships.put("battleShip", new Ship(2));
		ships.put("subMarine", new Ship(3));
		ships.put("destroyer", new Ship(4));
		ships.put("patrolBoat", new Ship(5));
		
		for(String key : ships.keySet()) {
			
			this.placeShip(ships.get(key));
		}
	}
	
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
			}
		}
	}
	
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
	
	private String generateRandomKey() {
		
		Random rand = new Random();		
		String characters = "ABCDEFGHIJ";
		int randChar = rand.nextInt(9) + 0;
		
		int y = rand.nextInt(10) + 1;
		char x = characters.charAt(randChar);
		
		return x+""+y;
	}
	
	public void print() {
		
		for(int i=10; i >= 1; i--) {
						
			if(i < 10) {
				
				Main.out.print(" " + i);
			} 
			else {
				Main.out.print(i);
			}
			
			for(char a = 'A'; a < 'K'; a++) {
				
				Square sq = this.getMap().get(a+""+i);
				
				if(sq.isShot() && sq.getShip() != "none") {
					
					Main.out.print(sq.getShip());
				}
				if(sq.isShot() && sq.getShip() != "none") {
					
					Main.out.print("~");
				}
				
				else {
					
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
				
				Square sq = this.getMap().get(a+""+i);
				
				if(!sq.getShip().equals("none")) {
					
					Main.out.print(sq.getShip());
				}
				
				else {
					
					Main.out.print(".");
				}
			}
			
			Main.out.print("\n");
		}
		
		Main.out.println("  ABCDEFGHIJ\n");
	}
}
