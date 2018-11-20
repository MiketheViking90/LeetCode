package designpatterns.strategy;

public class Gun implements Weapon {

    @Override
    public void use() {
        System.out.println("Shoot gun pew pew!");
    }

}
