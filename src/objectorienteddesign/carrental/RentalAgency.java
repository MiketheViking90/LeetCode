package objectorienteddesign.carrental;

import java.time.LocalDateTime;
import java.util.*;

public class RentalAgency {

    private final Map<Make, Queue<Rental>> carsByModel = new HashMap<>();
    private final Map<CarType, Queue<Rental>> carsByType = new HashMap<>();
    private final Set<Car> rentedCars = new HashSet<>();

    private double revenue = 0;

    public void rentCar(Renter renter, LocalDateTime rentalDate, LocalDateTime dueDate) {
        Rental rental = carsByModel.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().size())).get().getValue().poll();
        rental = new GPS(rental);
        rental = new Insurance(rental);

        rental.rent(renter, rentalDate, dueDate);
        revenue += rental.getRentalCost();
    }

    public void returnCar(Rental rental, LocalDateTime returnDate) {
        if (returnDate.isAfter(rental.getDueDate())) {
            revenue += rental.getLateFee();
        }
        returnRental(rental);
    }

    public void returnRental(Rental rental) {
        rentedCars.remove(rental);
        carsByModel.get(rental.getModel()).offer(rental);
        carsByType.get(rental.getCarType()).offer(rental);
    }
}