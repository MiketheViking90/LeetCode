package objectorienteddesign.parkinglot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParkingSpot {
    private final int id;
    private final ParkingSpotType type;
    private Vehicle occupied;

    public boolean addVehicle(Vehicle vehicle) {
        if (type.canFit(vehicle)) {
            this.occupied = vehicle;
            return true;
        }
        return false;
    }

    public void removeVehicle() {
        this.occupied = null;
    }
}
