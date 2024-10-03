package vehicle;

public class Car extends Vehicle {
	
	public Car(int id) {
		super(id,150);
		this.vehicleType = VehicleType.CAR;
		this.vehicleSize = VehicleTypeSize.getSizeForType(this.vehicleType);
	}
	
}
