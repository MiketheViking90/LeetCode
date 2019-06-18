package objectorienteddesign.carrental;

import lombok.Getter;

public class GPS extends AddOn {
    @Getter
    private final double price = 10;

    public GPS(Rental rental) {
        super(rental);
    }
}
