package objectorienteddesign.parkinglot;

public enum ParkingSpotType {
    CYCLE,
    COMPACT,
    NORMAL;

    public boolean canFit(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getType();
        if (this == CYCLE) {
            return vehicleType == VehicleType.MOTORCYCLE;
        } else if (this == COMPACT) {
            return vehicleType == VehicleType.MOTORCYCLE ||
                vehicleType == VehicleType.SPORTS ||
                vehicleType == VehicleType.SEDAN;
        } else {
            return true;
        }
    }
}
