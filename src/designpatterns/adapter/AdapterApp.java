package designpatterns.adapter;

public class AdapterApp {

    public static void main(String[] args) {
        Duck duck1 = new Duck();
        Chicken chicken1 = new DuckToChickenAdapter(duck1);

        chicken1.cluck();
        chicken1.fly();

        Chicken realChicken = new RealChicken();
        realChicken.cluck();
        realChicken.fly();
    }

}
