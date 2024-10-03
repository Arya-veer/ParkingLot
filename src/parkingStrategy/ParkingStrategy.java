package parkingStrategy;
import parkingSpot.ParkingSpotType;
import vehicle.*;

public abstract class ParkingStrategy {
	
	public abstract boolean occupy(Vehicle vehicle,ParkingSpotType parkingSpotType);
	public abstract int vacate(Vehicle vehicle,int rate);
	protected abstract boolean isOccupied();
	public abstract boolean canBook(Vehicle vehicle,ParkingSpotType parkingSpotType);
}
