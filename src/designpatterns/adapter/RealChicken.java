package designpatterns.adapter;

public class RealChicken implements Chicken {
    @Override
    public void cluck() {
        System.out.println("cluck cluck");
    }

    @Override
    public void fly() {
        System.out.println("flap flap");
    }
}
