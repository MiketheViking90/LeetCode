package designpatterns.decorator;

import lombok.Getter;

@Getter
public class Coffee extends BaseDrink {

    private double price = 1.5;
    private String name = "coffee";

}
