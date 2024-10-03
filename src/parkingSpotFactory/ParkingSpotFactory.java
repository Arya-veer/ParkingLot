package parkingSpotFactory;

import parkingSpot.BikeSpot;
import parkingSpot.CarSpot;
import parkingSpot.ParkingSpot;
import parkingSpot.ParkingSpotType;
import parkingSpot.TruckSpot;
import parkingStrategy.*;

public interface ParkingSpotFactory {
	
	public ParkingSpot getParkingSpot(int number,ParkingStrategyType parkingStrategyType) throws Exception;
	
	public default ParkingSpot getParkingSpot(ParkingSpotType type,int number,ParkingStrategyType parkingStrategyType) throws Exception {
		switch(type) {
			case ParkingSpotType.BIKE_SPOT: return new BikeSpot(number,parkingStrategyType);
			case ParkingSpotType.CAR_SPOT: return new CarSpot(number,parkingStrategyType);
			case ParkingSpotType.TRUCK_SPOT: return new TruckSpot(number,parkingStrategyType);
			default: throw new Exception("Invalid parking spot type");
		}
	}
}
