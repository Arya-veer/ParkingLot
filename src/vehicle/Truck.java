package vehicle;

public class Truck extends Vehicle {
	
	public Truck(int id) {
		super(id,300);
		this.vehicleType = VehicleType.TRUCK;
		this.vehicleSize = VehicleTypeSize.getSizeForType(this.vehicleType);
	}
	
}
