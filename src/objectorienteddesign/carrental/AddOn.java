package objectorienteddesign.carrental;

import java.time.LocalDateTime;

public abstract class AddOn implements Rental {
    protected final Rental rental;
    protected double price;

    public AddOn(Rental rental) {
        this.rental = rental;
    }

    @Override
    public double getRentalCost() {
        return price + rental.getRentalCost();
    }

    @Override
    public double getLateFee() {
        return price + rental.getLateFee();
    }

    @Override
    public void rent(Renter renter, LocalDateTime rentalDate, LocalDateTime dueDate) {
        rental.rent(renter, rentalDate, dueDate);
    }

    @Override
    public LocalDateTime getDueDate() {
        return rental.getDueDate();
    }

    @Override
    public LocalDateTime getRentalDate() {
        return rental.getRentalDate();
    }

    @Override
    public Renter getRenter() {
        return rental.getRenter();
    }

    @Override
    public Make getModel() {
        return rental.getModel();
    }

    @Override
    public CarType getCarType() {
        return rental.getCarType();
    }
}
