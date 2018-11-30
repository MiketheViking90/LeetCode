package designpatterns.decorator;

public class Sugar implements Drink {

    private final double price = .25;
    private final String name = "sugar";
    private final Drink drink;

    public Sugar(Drink drink) {
        this.drink = drink;
    }

    public String getName() {
        return drink.getName() + " with sugar";
    }

    public double getPrice() {
        return drink.getPrice() + price;
    }

}
