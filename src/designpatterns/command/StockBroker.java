package designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class StockBroker {

    private final List<StockCommand> commands = new ArrayList<>();

    public void acceptCommand(StockCommand command) {
        this.commands.add(command);
    }

    public void doCommands() {
        for (StockCommand cmd : commands) {
            cmd.execute();
        }
    }
}
