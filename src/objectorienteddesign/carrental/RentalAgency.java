package objectorienteddesign.carrental;

import objectorienteddesign.parkinglot.Vehicle;

import java.util.List;

public class RentalAgency {
    List<ParkingSpot> parkingSpots;

    public void parkVehicle(int parkingSpot, Vehicle vehicle) {
        parkingSpots.get(parkingSpot);
    }
}
