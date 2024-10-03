package vehicle;

public class Bike extends Vehicle {
	
	public Bike(int id) {
		super(id,100);
		this.vehicleType = VehicleType.BIKE;
		this.vehicleSize = VehicleTypeSize.getSizeForType(this.vehicleType);
	}
	
}
