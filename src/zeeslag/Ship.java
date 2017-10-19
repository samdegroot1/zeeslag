package zeeslag;

public class Ship {
	
	private String name;
	private int size;
	private boolean destroyed = false;

	public Ship(int type) {
	
		if(type == 1) {
			
			this.setName("Vliegdekschip");
			this.setSize(5);
		}
		
		if(type == 2 ) {
			
			this.setName("Slagschip");
			this.setSize(4);
		}
		
		if(type == 3) {
			
			this.setName("Onderzeeër");
			this.setSize(3);			
		}
		
		if(type == 4) {
			
			this.setName("Torpedobootjager");
			this.setSize(3);
		}
		
		if(type == 5) {
			
			this.setName("Patrouilleboot");
			this.setSize(2);
		}
	}

	public String getName() {
	
		return name;
	}

	private void setName(String name) {
	
		this.name = name;
	}

	public int getSize() {
	
		return size;
	}

	private void setSize(int size) {
	
		this.size = size;
	}

	public boolean getDestroyed() {
	
		return destroyed;
	}

	private void setDestroyed(boolean destroyed) {
	
		this.destroyed = destroyed;
	}
	
	public void destroyShip() {
		
		this.setDestroyed(true);
	}
}
