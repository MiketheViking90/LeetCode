package objectorienteddesign.carrental;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class ParkingSpot {
    private final int id;
    private Vehicle vehicle;
}
