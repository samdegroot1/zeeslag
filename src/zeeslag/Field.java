package zeeslag;

import java.util.HashMap;

public class Field {

	private HashMap <String, Square> map;
	private int sunkShips;
	
	public Field() {
		
		this.setMap(new HashMap<String, Square>());
		this.generateField();
	}
	
	public HashMap<String, Square> getMap() {
		
		return this.map;
	}
	
	public void setMap(HashMap<String, Square> map) {
		
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
			
				map.put(i+""+a, new Square());
			}			
		}
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
				
				Square sq = map.get(i+""+a);
				
				if(sq.isShot() && sq.getShip() != null) {
					
					Main.out.print("~");
				}
				if(sq.isShot() && sq.getShip() != null) {
					
					Main.out.print("~");
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
