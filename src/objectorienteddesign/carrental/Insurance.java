package objectorienteddesign.carrental;

import lombok.Getter;

public class Insurance extends AddOn {
    @Getter
    private final double price = 15;

    public Insurance(Rental rental) {
        super(rental);
    }
}
