package objectorienteddesign.carrental;

import java.time.LocalDateTime;

public interface Rental {
    void rent(Renter renter, LocalDateTime rentalDate, LocalDateTime dueDate);

    LocalDateTime getDueDate();

    LocalDateTime getRentalDate();

    double getRentalCost();

    double getLateFee();

    Renter getRenter();

    Make getModel();

    CarType getCarType();
}
