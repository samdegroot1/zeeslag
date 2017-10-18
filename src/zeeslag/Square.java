package zeeslag;

public class Square {

	private char ship;
	private boolean shot;
	
	public char getShip() {
	
		this.setShot(false);
		return ship;
	}
	public void setShip(char ship) {
	
		this.ship = ship;
	}
	public boolean isShot() {
	
		return shot;
	}
	public void setShot(boolean shot) {
	
		this.shot = shot;
	}
}
