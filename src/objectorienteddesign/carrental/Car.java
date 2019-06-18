package objectorienteddesign.carrental;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class Car implements Rental {
    private final Make make;
    private final CarType type;

    private LocalDateTime rentalDate = LocalDateTime.of(1900,1,1,0,0,0);;
    private LocalDateTime dueDate = LocalDateTime.of(1900,1,1,0,0,0);
    private Renter renter;

    private PriceStrategy priceStrategy;
    private PriceStrategy lateStrategy;

    List<Event> history;

    @Override
    public void rent(Renter renter, LocalDateTime rentalDate, LocalDateTime dueDate) {
        this.renter = renter;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
    }

    public double getRentalCost() {
        return priceStrategy.getPrice(rentalDate, dueDate);
    }

    public double getLateFee() {
        return lateStrategy.getPrice(rentalDate, dueDate);
    }

    @Override
    public Make getModel() {
        return make;
    }

    @Override
    public CarType getCarType() {
        return type;
    }
}
