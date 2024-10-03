package parkingSpot;

import parkingStrategy.*;

public class BikeSpot extends ParkingSpot {


	public BikeSpot(int number,ParkingStrategyType parkingStrategyType) {
		this.type = ParkingSpotType.BIKE_SPOT;
		this.parkingStrategy = ParkingStrategyFactory.getStrategy(parkingStrategyType);
		this.number = number;
		// TODO Auto-generated constructor stub
	}
}
