package objectorienteddesign.parkinglot;

import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;

public class ParkingLot {
    List<Floor> floors;
    PricingStrategy pricingStrategy;
    double revenue = 0;

    public void vehicleEnters(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket(LocalDateTime.now());
        vehicle.assignTicket(ticket);

        ParkingSpot firstSpot = findParkingSpot(floors, vehicle);
        firstSpot.addVehicle(vehicle);
    }

    public void vehicleExits(Vehicle vehicle) {
        double price = pricingStrategy.getPrice(vehicle.getParkingTicket(), LocalDateTime.now());
        revenue += price;
    }

    private ParkingSpot findParkingSpot(List<Floor> floors, Vehicle vehicle) {
        ParkingSpotType fit = getParkingSpotType(vehicle);
        return getParkingSpot(floors, fit);
    }

    private ParkingSpot getParkingSpot(List<Floor> floors, ParkingSpotType fit) {
        for (Floor floor :floors) {
            PriorityQueue<ParkingSpot> spots = floor.parkingSpots.get(fit);
            if (!spots.isEmpty()) {
                return spots.poll();
            }
        }
        return null;
    }

    private ParkingSpotType getParkingSpotType(Vehicle vehicle) {
        ParkingSpotType fit = null;
        for (ParkingSpotType spotType : ParkingSpotType.values()) {
            if (spotType.canFit(vehicle)) {
                fit = spotType;
            }
        }
        return fit;
    }

}
