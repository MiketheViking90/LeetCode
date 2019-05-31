package objectorienteddesign.parkinglot;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double getPrice(ParkingTicket ticket, LocalDateTime exitTime);
}
