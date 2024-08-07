package command;

import business.Clothing;
import business.Skirt;

public class SetPatternCommand implements Command {
    private String pattern;

    public SetPatternCommand(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setPattern(pattern);
        }
    }
}
