package zeeslag;

public class Square {

	private String ship;
	private int shipType;
	private boolean shot;
	
	
	public Square() {
	
		this.setShot(false);
		this.setShip("none");
	}
	
	public String getShip() {
			
		return this.ship;
	}
	public void setShip(String ship) {
	
		this.ship = ship;
	}
	public boolean isShot() {
	
		return this.shot;
	}
	public void setShot(boolean shot) {
	
		this.shot = shot;
	}
	
	public void setShipType(int type) {
		
		this.shipType = type;
	}
	
	public int getShipType() {
		
		return this.shipType;
	}
}
