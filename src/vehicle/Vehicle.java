package vehicle;
import java.util.UUID;

public abstract class Vehicle {
	
	private int id;
	
	protected int rate;
	
	public Vehicle(int id,int rate) {
		this.id = id;
		this.rate = rate;
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleType=" + vehicleType + ", vehicleSize=" + vehicleSize + "]";
	}

	protected VehicleType vehicleType;
	
	protected int vehicleSize;
	
	public VehicleType getVehicleType() {
		return this.vehicleType;
	}
	
	public int getVehicleSize() {
		return this.vehicleSize;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getRate() {
		return this.rate;
	}
}
