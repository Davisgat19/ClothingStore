package command;

import business.Clothing;
import business.Pants;

public class LengthCommand implements Command {
    private String length;

    public LengthCommand(String length) {
        this.length = length;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setLength(length);
            System.out.println("Pants length adjusted to: " + length);
        }
    }
}