package objectorienteddesign.parkinglot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AdditivePricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(ParkingTicket ticket, LocalDateTime exitTime) {
        LocalDateTime startTime = ticket.getStartTime();
        ticket.hasPaid = true;
        return 60*ChronoUnit.MINUTES.between(startTime, exitTime);
    }
}
