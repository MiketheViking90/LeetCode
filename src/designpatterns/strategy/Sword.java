package designpatterns.strategy;

public class Sword implements Weapon {

    @Override
    public void use() {
        System.out.println("swing sword");
    }

}
