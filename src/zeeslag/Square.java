package zeeslag;

public class Square {

	private String ship;
	private boolean shot;
	
	
	public Square() {
	
		this.setShot(false);
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
}
