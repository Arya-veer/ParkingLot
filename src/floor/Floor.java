package floor;
import java.util.*;
import parkingSpot.*;
import parkingSpotFactory.ParkingSpotFactory;
import parkingStrategy.*;
import vehicle.*;


public class Floor {
	
	private int number;
	
	private List<ParkingSpot> parkingSpots;
	
	private static final int FLOOR_SIZE = 10;
	
	private void initializeParkingSpots(ParkingStrategyType parkingStrategyType,ParkingSpotFactory parkingSpotFactory) {
		this.parkingSpots = new ArrayList<>();
		for(int i = 1;i<=FLOOR_SIZE;i++) {
			try {
				ParkingSpot parkingSpot = parkingSpotFactory.getParkingSpot(i,parkingStrategyType);
				this.parkingSpots.add(parkingSpot);
			} catch (Exception e) {
				System.out.println("Not able to add parking spot");
				System.out.println(e.getMessage());
			}
					
		}
	}
	
	public Floor(int number,ParkingStrategyType parkingStrategyType,ParkingSpotFactory parkingSpotFactory){
		this.number = number;
		this.initializeParkingSpots(parkingStrategyType,parkingSpotFactory);
	}
	
	public ParkingSpot search(Vehicle vehicle) {
		for(ParkingSpot parkingSpot:this.parkingSpots) {
			if(parkingSpot.getParkingStrategy().canBook(vehicle,parkingSpot.getType())) {
				System.out.println(parkingSpot);
				return parkingSpot;
			}
		}
//		System.out.println("No spot found for " + vehicle + " on floor: " + this.number);
		return null;
	}
	
	@Override
	public String toString() {
		return "Floor [number=" + number + "]";
	}

	public int getNumber() {
		return this.number;
	}
	
}
