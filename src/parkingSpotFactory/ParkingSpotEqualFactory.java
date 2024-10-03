package parkingSpotFactory;

import java.util.Arrays;
import java.util.List;

import parkingSpot.ParkingSpot;
import parkingSpot.ParkingSpotType;
import parkingStrategy.ParkingStrategyType;

public class ParkingSpotEqualFactory implements ParkingSpotFactory{
	
	private static int vehicleCount = 0;

	@Override
	public ParkingSpot getParkingSpot(int number, ParkingStrategyType parkingStrategyType) throws Exception {
		// TODO Auto-generated method stub
		List<ParkingSpotType> types = Arrays.asList(ParkingSpotType.values());
		ParkingSpotType type = types.get(vehicleCount%types.size());
		vehicleCount++;
		return this.getParkingSpot(type, number, parkingStrategyType);
	}
	
}
