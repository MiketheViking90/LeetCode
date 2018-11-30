package designpatterns.decorator;

public class Milk implements Drink {

    private final double price = .5;
    private final String name = "milk";
    private final Drink drink;

    public Milk(Drink drink) {
        this.drink = drink;
    }

    public String getName() {
        return drink.getName() + " with milk";
    }

    public double getPrice() {
        return drink.getPrice() + price;
    }

}
