package designpatterns.command;

public abstract class StockCommand {

    protected Stock stock;

    public StockCommand(Stock stock) {
        this.stock = stock;
    }

    public abstract void execute();

}
