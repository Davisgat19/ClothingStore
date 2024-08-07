package command;

import business.Clothing;
import business.Pants;

public class SetLengthCommand implements Command {
    private String length;

    public SetLengthCommand(String length) {
        this.length = length;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setLength(length);
        }
    }
}
