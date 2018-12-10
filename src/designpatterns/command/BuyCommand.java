package designpatterns.command;

public class BuyCommand extends StockCommand {

    public BuyCommand(Stock stock) {
        super(stock);
    }

    @Override
    public void execute() {
        stock.buy();
    }

}
