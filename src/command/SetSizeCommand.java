package command;

import business.Clothing;

public class SetSizeCommand implements Command {
    private String size;

    public SetSizeCommand(String size) {
        this.size = size;
    }

    @Override
    public void execute(Clothing clothing) {
        clothing.setSize(size);
    }
}