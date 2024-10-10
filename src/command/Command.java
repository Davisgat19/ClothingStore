package command;

import business.Clothing;

public interface Command {
    void execute(Clothing clothing);
}
