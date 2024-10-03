package parkingSpotFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import parkingSpot.ParkingSpot;
import parkingSpot.ParkingSpotType;
import parkingStrategy.ParkingStrategyType;

public class ParkingSpotRandomFactory implements ParkingSpotFactory{

	@Override
	public ParkingSpot getParkingSpot(int number, ParkingStrategyType parkingStrategyType) throws Exception {
		// TODO Auto-generated method stub
		List<ParkingSpotType> types = Arrays.asList(ParkingSpotType.values());
		Collections.shuffle(types);
		ParkingSpotType type = types.get(0);
		return this.getParkingSpot(type, number, parkingStrategyType);
	}
	
}
