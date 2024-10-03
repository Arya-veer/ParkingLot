package parkingSpot;

import parkingStrategy.*;

public class TruckSpot extends ParkingSpot {
	
	public TruckSpot(int number,ParkingStrategyType parkingStrategyType) {
		
		this.type = ParkingSpotType.TRUCK_SPOT;
		this.parkingStrategy = ParkingStrategyFactory.getStrategy(parkingStrategyType);
		this.number = number;
	}

}
