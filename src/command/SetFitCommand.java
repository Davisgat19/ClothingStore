package command;

import business.Clothing;
import business.Pants;

public class SetFitCommand implements Command {
    private String fit;

    public SetFitCommand(String fit) {
        this.fit = fit;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setFit(fit);
        }
    }
}
