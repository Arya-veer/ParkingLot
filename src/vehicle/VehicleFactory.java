package vehicle;

public interface VehicleFactory {
	
	public static Vehicle getVehicle(String vehicleType,int vehicleId) throws Exception {
		switch(vehicleType) {
			case "BIKE": return new Bike(vehicleId);
			case "CAR": return new Car(vehicleId);
			case "TRUCK": return new Truck(vehicleId);
			default: throw new Exception("Invalid vehicle type: " + vehicleType);
		}
	}
}
