package designpatterns.command;

public class SellCommand extends StockCommand {

    public SellCommand(Stock stock) {
        super(stock);
    }

    @Override
    public void execute() {
        stock.sell();
    }


}
