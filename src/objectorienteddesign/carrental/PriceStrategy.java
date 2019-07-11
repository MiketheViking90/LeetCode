package objectorienteddesign.carrental;

import java.time.LocalDateTime;

public interface PriceStrategy {
    double getPrice(LocalDateTime rentalDate, LocalDateTime dueDate);
}
