package zeeslag;

public class Ship {
	
	private String name;
	private int size;
	private boolean destroyed;

	public Ship(int type) {
	
		if(type == 1) {
			
			this.setName("Vliegdekschip");
			this.setSize(5);
			this.setDestroyed(false);
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

	public void setDestroyed(boolean destroyed) {
	
		this.destroyed = destroyed;
	}
}
