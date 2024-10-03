package parkingStrategy;

public interface ParkingStrategyFactory {
	
	public static ParkingStrategy getStrategy(ParkingStrategyType strategyType) {
		switch(strategyType) {
			case ParkingStrategyType.SINGLE_PARKING: return new SingleParking();
			case ParkingStrategyType.HYBRID_PARKING: return new HybridParking();
			default: return null;
		}
	}
}
