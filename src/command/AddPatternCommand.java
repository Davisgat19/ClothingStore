package command;

import business.Clothing;
import business.Skirt;

public class AddPatternCommand implements Command {
    private String pattern;

    public AddPatternCommand(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setPattern(pattern);
            System.out.println("Skirt pattern adjusted to: ");
        }
    }
}
