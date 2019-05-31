package objectorienteddesign.vendingmachine;

import java.util.Queue;

public class VendingMachine {
    private final Slot[][] slots;
    private double userMoney;

    public VendingMachine(int x, int y) {
        this.slots = new Slot[x][y];
    }

    public void acceptMoney(double userMoneyInput) {
        userMoney += userMoneyInput;
    }

    public Item vendItem(int x, int y) {
        Queue<Item> itemsAtLocation = slots[x][y].getItems();
        if (itemsAtLocation.isEmpty()) {
            return null;
        }

        double itemPrice = itemsAtLocation.peek().getPrice();
        if (userMoney >= itemPrice ) {
            userMoney -= itemPrice;

            returnChange();
            userMoney = 0.0;
            return itemsAtLocation.poll();
        }
        return null;
    }

    private double returnChange() {
        return userMoney;
    }

}
