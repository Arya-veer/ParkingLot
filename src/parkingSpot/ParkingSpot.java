package parkingSpot;
import parkingStrategy.ParkingStrategy;
import vehicle.*;

public abstract class ParkingSpot {
	
	protected int number;
	
	protected ParkingSpotType type;
	
	Vehicle vehicle = null;
	
	protected ParkingStrategy parkingStrategy;
	
	
	public ParkingSpotType getType() {
		return this.type;
	}

	public ParkingStrategy getParkingStrategy() {
		return this.parkingStrategy;
	}
	
	@Override
	public String toString() {
		return "ParkingSpot [number=" + number + ", type=" + type + "]";
	}

	public int getNumber() {
		return this.number;
	}
}
