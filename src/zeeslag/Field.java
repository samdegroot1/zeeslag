package zeeslag;

import java.util.HashMap;

public class Field {

	private HashMap <String, Square> field;
	private int sunkShips;
	
	public Field() {
		
		this.setField(new HashMap());
		this.generateField();
	}

	
	private void setField(HashMap field) {
		
		this.field = field;
	}


	private  void generateField() {
		
		for(int i=0; i < 11; i++) {
			
			for(char a = 'A'; a < 'K'; a++) {
			
				field.put(i+"_"+a, new Square());
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
				
				Square test = field.get(i+"_"+a);
				
				if(test.isShot()) {
					
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
