package designpatterns.decorator;

public abstract class Topping implements Drink {

    private final Drink drink;
    protected String name;
    protected double price;

    public Topping(Drink drink) {
        this.drink = drink;
    }

    public double getPrice() {
        return drink.getPrice() + price;
    }

    public String getName() {
        return drink.getName() + " with " + name;
    }
}
