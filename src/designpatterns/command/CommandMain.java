package designpatterns.command;

public class CommandMain {

    public static void main(String[] args) {
        Stock amzn = new Stock("AMZN", 12);
        StockCommand sellCommand = new SellCommand(amzn);
        StockCommand buyCommand = new BuyCommand(amzn);

        StockBroker broker1 = new StockBroker();
        broker1.acceptCommand(buyCommand);
        broker1.acceptCommand(buyCommand);
        broker1.acceptCommand(buyCommand);
        broker1.acceptCommand(sellCommand);

        broker1.doCommands();
    }

}
