package vehicle;

interface VehicleTypeSize {
	
	static int getSizeForType(VehicleType vehicleType) {
		switch(vehicleType) {
			case VehicleType.BIKE: return 1;
			case VehicleType.CAR: return 4;
			case VehicleType.TRUCK: return 7;
			default: return 10;
		}
	}
}
