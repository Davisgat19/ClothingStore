package command;

import business.Clothing;
import java.util.ArrayList;
import java.util.List;

public class CommandPipeline {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute(Clothing clothing) {
        for (Command command : commands) {
            command.execute(clothing);
        }
    }
}
