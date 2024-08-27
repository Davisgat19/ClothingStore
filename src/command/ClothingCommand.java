package command;

import business.Clothing;

public interface ClothingCommand {
    void execute(Clothing clothing);
}
