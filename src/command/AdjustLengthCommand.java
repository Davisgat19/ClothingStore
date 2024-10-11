package command;

import business.Clothing;
import business.Pants;

public class AdjustLengthCommand implements Command{
    private String length;

    public AdjustLengthCommand(String length) {
        this.length = length;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setLength(length);
            System.out.println("Pants length adjusted to: ");
        }
    }
}
