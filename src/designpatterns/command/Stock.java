package designpatterns.command;

public class Stock {

    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("bought " + quantity + " shares of " + name);
    }

    public void sell() {
        System.out.println("sold " + quantity + " shares of " + name);
    }

}
