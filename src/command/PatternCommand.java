package command;

import business.Clothing;
import business.Skirt;

public class PatternCommand implements Command {
    private String pattern;

    public PatternCommand(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setPattern(pattern);
            System.out.println("Skirt pattern adjusted to: " + pattern);
        }
    }
}
