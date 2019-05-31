package objectorienteddesign.parkinglot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Vehicle {
    private final VehicleType type;
    private ParkingTicket parkingTicket;

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
    }
}
