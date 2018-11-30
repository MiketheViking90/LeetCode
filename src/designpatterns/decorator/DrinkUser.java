package designpatterns.decorator;

public class DrinkUser {

    public static void main(String[] args) {
        Drink drink = new Coffee();
        System.out.println(drink.getName() + ", " + drink.getPrice());

        drink = new Milk(drink);
        System.out.println(drink.getName() + ", " + drink.getPrice());

        drink = new Milk(drink);
        System.out.println(drink.getName() + ", " + drink.getPrice());

        drink = new Milk(drink);
        System.out.println(drink.getName() + ", " + drink.getPrice());

        drink = new Sugar(drink);
        System.out.println(drink.getName() + ", " + drink.getPrice());
    }

}
