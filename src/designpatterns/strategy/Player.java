package designpatterns.strategy;

public class Player {

    private String name;
    private Weapon weapon;

    public Player(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == null) {
            System.out.println("No weapon!");
            return;
        }

        System.out.println(name + " attacks!");
        weapon.use();
        System.out.println();
    }

    public static void main(String[] args) {
        Player p1 = new Player("Jim");
        Player p2 = new Player("Jac");

        p1.attack();
        p2.attack();

        Weapon w1 = new Sword();
        Weapon w2 = new Gun();

        p1.setWeapon(w1);
        p2.setWeapon(w2);

        p1.attack();
        p2.attack();
    }
}
