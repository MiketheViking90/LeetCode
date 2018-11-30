package designpatterns.decorator;

import lombok.Getter;

@Getter
public class Espresso implements Drink {

    private final double price = 2.00;
    private final String name = "espresso";

}
