package parkingSpot;

import parkingStrategy.*;

public class CarSpot extends ParkingSpot {
	


	public CarSpot(int number,ParkingStrategyType parkingStrategyType) {
		this.parkingStrategy = ParkingStrategyFactory.getStrategy(parkingStrategyType);
		this.number = number;
		this.type = ParkingSpotType.CAR_SPOT;
		// TODO Auto-generated constructor stub
	}

}
