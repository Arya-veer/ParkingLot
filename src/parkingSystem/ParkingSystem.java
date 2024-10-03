package parkingSystem;

import parkingSpotFactory.*;
import parkingLot.ParkingLot;
import parkingStrategy.*;
import vehicle.*;

import java.util.*;

import java.io.*;

public class ParkingSystem {
	
	
	
	static {
		System.out.println("********************MENU********************");
		System.out.println("FORMAT:");
		System.out.println();
		System.out.println("Number of operations");
		System.out.println();
		System.out.println("Park car: 0 VEHICLE_ID VEHICLE_TYPE");
		System.out.println();
		System.out.println("UnPark car: 1 VEHICLE_ID");
		System.out.println();
		System.out.println("Exit: 2");
		System.out.println("VEHICLE_TYPES: BIKE,CAR,TRUCK");
	}
	
	private static Map<Integer,Vehicle> vehicles = new HashMap<>();
	
	
	
	public static void main(String[] args) {
		
		ParkingStrategyType parkingStrategyType = ParkingStrategyType.HYBRID_PARKING;
		ParkingSpotFactory parkingSpotFactory = new ParkingSpotEqualFactory();
		ParkingLot parkingLot = new ParkingLot(10,parkingStrategyType,parkingSpotFactory);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int operation = sc.nextInt();
			if(operation == 2) return;
			int vehicleId = sc.nextInt();
			if(operation == 0) {
				Vehicle vehicle;
				try {
					vehicle = VehicleFactory.getVehicle(sc.next(),vehicleId);
					vehicles.put(vehicleId, vehicle);
					parkingLot.parkVehicle(vehicle);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					parkingLot.removeVehicle(vehicles.get(vehicleId));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
}
