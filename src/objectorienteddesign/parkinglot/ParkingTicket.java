package objectorienteddesign.parkinglot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ParkingTicket {
    private final LocalDateTime startTime;
    boolean hasPaid = false;
}
