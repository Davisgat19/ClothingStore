package command;

import business.Clothing;
import business.Pants;

public class FitCommand implements Command {
    private String fit;

    public FitCommand(String fit) {
        this.fit = fit;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setFit(fit);
            System.out.println("Pants fit adjusted to: " + fit);
        }
    }
}
