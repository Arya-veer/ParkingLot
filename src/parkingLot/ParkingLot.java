package parkingLot;

import floor.*;
import parkingSpot.ParkingSpot;
import parkingSpotFactory.ParkingSpotFactory;

import java.util.*;
import parkingStrategy.*;
import vehicle.Vehicle;

public class ParkingLot {
	
	private List<Floor> floors;
	private Map<Integer,ParkingSpot> parking;
	
	private void initializeFloors(int floorCount,ParkingStrategyType parkingStrategyType,ParkingSpotFactory parkingSpotFactory) {
		this.floors = new ArrayList<>();
		for(int i = 1;i<=floorCount;i++) {
			this.floors.add(new Floor(i, parkingStrategyType,parkingSpotFactory));
		}
	}
	
	public ParkingLot(int floorCount,ParkingStrategyType parkingStrategyType,ParkingSpotFactory parkingSpotFactory) {
		
		this.initializeFloors(floorCount,parkingStrategyType,parkingSpotFactory);
		this.parking = new HashMap<>();
	}
	
	public void parkVehicle(Vehicle vehicle) throws Exception {
		ParkingSpot spot = null;
		for(Floor floor:this.floors) {
			spot = floor.search(vehicle);
			while(spot != null && !spot.getParkingStrategy().occupy(vehicle,spot.getType())) {
				spot = floor.search(vehicle);
			}
			if(spot != null) {
				this.parking.put(vehicle.getId(), spot);
				System.out.println("Successfully parked " + vehicle + " at " + spot + " on " + floor);
				System.out.println("Parking rate: " + vehicle.getRate() + " per hour");
				return;
			}
		}
		throw new Exception(vehicle + "can not be parked");
		
	}
	
	public void removeVehicle(Vehicle vehicle) {
		ParkingSpot spot = this.parking.remove(vehicle.getId());
		int charge = spot.getParkingStrategy().vacate(vehicle, vehicle.getRate());
		System.out.println("Please pay: " + charge);
	}

}
