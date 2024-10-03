package parkingStrategy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import parkingSpot.ParkingSpotType;

import java.util.*;

import timer.Timer;
import vehicle.*;

public class SingleParking extends ParkingStrategy {

	protected volatile boolean occupied = false;
	
	protected Lock lock;
	
	private int occupied_at;
	
	private static Map<VehicleType,ParkingSpotType> VEHICLE_TO_PARKING_SPOT_MAPPING = new HashMap<>();
	
	
	static {
		VEHICLE_TO_PARKING_SPOT_MAPPING.put(VehicleType.CAR, ParkingSpotType.CAR_SPOT);
		VEHICLE_TO_PARKING_SPOT_MAPPING.put(VehicleType.BIKE, ParkingSpotType.BIKE_SPOT);
		VEHICLE_TO_PARKING_SPOT_MAPPING.put(VehicleType.TRUCK, ParkingSpotType.TRUCK_SPOT);
	}
	
	public SingleParking() {
		this.lock = new ReentrantLock();
	}
	
	@Override
	public boolean occupy(Vehicle vehicle,ParkingSpotType parkingSpotType) {
		if(! this.canBook(vehicle,parkingSpotType)) return false;
		this.lock.lock();
		if(! this.canBook(vehicle,parkingSpotType)) {
			this.lock.unlock();
			return false;
		}
		this.occupied = true;
		this.occupied_at = Timer.getTimestamp();
		this.lock.unlock();
		return true;
	}
	
	@Override
	public int vacate(Vehicle vehicle,int rate) {
		// TODO Auto-generated method stub
		if(! this.isOccupied()) return -1;
		this.occupied = false;
		return rate*(Timer.getTimestamp() - this.occupied_at);
	}

	@Override
	protected boolean isOccupied() {
		
		return this.occupied;
	}
	
	public boolean canBook(Vehicle vehicle,ParkingSpotType spotType) {
		ParkingSpotType mappedType = VEHICLE_TO_PARKING_SPOT_MAPPING.get(vehicle.getVehicleType());
		if(mappedType != null)
		if(mappedType == null || !mappedType.equals(spotType)) return false;
		return !this.isOccupied();
	}
	
	
}
