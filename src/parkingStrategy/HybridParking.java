package parkingStrategy;

import parkingSpot.ParkingSpotType;
import vehicle.Vehicle;
import java.util.concurrent.locks.*;
import java.util.*;
import timer.Timer;

public class HybridParking extends ParkingStrategy {
	
	private int filledCapacity;
	private Lock lock;
	private Map<Integer,Integer> parkedAt;
	
	private static Map<ParkingSpotType,Integer> parkingSpotSize = new HashMap<>();;
	
	static {
		parkingSpotSize.put(ParkingSpotType.BIKE_SPOT, 1);
		parkingSpotSize.put(ParkingSpotType.CAR_SPOT, 4);
		parkingSpotSize.put(ParkingSpotType.TRUCK_SPOT, 7);
	}
	
	public HybridParking() {
		this.filledCapacity = 0;
		this.lock = new ReentrantLock();
		this.parkedAt = new HashMap<>();
	}

	@Override
	public boolean occupy(Vehicle vehicle, ParkingSpotType parkingSpotType) {
		// TODO Auto-generated method stub
		if(!this.canBook(vehicle, parkingSpotType)) return false;
		this.lock.lock();
		if(!this.canBook(vehicle, parkingSpotType)) {
			this.lock.unlock();
			return false;
		}
		this.filledCapacity += vehicle.getVehicleSize();
		this.parkedAt.put(vehicle.getId(), Timer.getTimestamp());
		this.lock.unlock();
		return true;
		
	}

	@Override
	public int vacate(Vehicle vehicle, int rate) {
		this.filledCapacity -= vehicle.getVehicleSize();
		return rate*(Timer.getTimestamp() - this.parkedAt.remove(vehicle.getId()));
	}

	@Override
	protected boolean isOccupied() {
		// TODO Auto-generated method stub
		return this.filledCapacity == 0;
	}

	@Override
	public boolean canBook(Vehicle vehicle, ParkingSpotType parkingSpotType) {
		System.out.println(parkingSpotSize.get(parkingSpotType));
		System.out.println(this.filledCapacity);
		System.out.println(vehicle.getVehicleSize());
		// TODO Auto-generated method stub
		if(parkingSpotSize.get(parkingSpotType) - this.filledCapacity < vehicle.getVehicleSize()) return false;
		
		return true;
	}
}
