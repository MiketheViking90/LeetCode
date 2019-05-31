package objectorienteddesign.parkinglot;

import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Getter
public class Floor {
    Map<ParkingSpotType, PriorityQueue<ParkingSpot>> parkingSpots = getParkingSpots();

    private Map<ParkingSpotType, PriorityQueue<ParkingSpot>> getParkingSpots() {
        Map<ParkingSpotType, PriorityQueue<ParkingSpot>> spots = new HashMap<>();
        spots.put(ParkingSpotType.COMPACT, getParkingSpotPQ());
        spots.put(ParkingSpotType.CYCLE, getParkingSpotPQ());
        spots.put(ParkingSpotType.NORMAL, getParkingSpotPQ());
        return spots;
    }

    private PriorityQueue<ParkingSpot> getParkingSpotPQ() {
        return new PriorityQueue<>(Comparator.comparing(ParkingSpot::getId));
    }


}
