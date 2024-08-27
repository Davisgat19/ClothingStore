package command;

import business.Clothing;
import java.util.ArrayList;
import java.util.List;

public class CommandPipeline {
    private final List<ClothingCommand> commands = new ArrayList<>();

    public void addCommand(ClothingCommand command) {
        commands.add(command);
    }

    public void execute(Clothing clothing) {
        for (ClothingCommand command : commands) {
            command.execute(clothing);
        }
    }
}
