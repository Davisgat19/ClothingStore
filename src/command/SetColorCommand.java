package command;

import business.Clothing;

public class SetColorCommand implements Command {
    private String color;

    public SetColorCommand(String color) {
        this.color = color;
    }

    @Override
    public void execute(Clothing clothing) {
        clothing.setColor(color);
    }
}
