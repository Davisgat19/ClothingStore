package command;

import business.Clothing;
import business.Pants;

public class AdjustFitCommand implements Command {
    private String fit;

    public AdjustFitCommand(String fit) {
        this.fit = fit;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Pants) {
            ((Pants) clothing).setFit(fit);
            System.out.println("Pants fit adjusted to: ");
        }
    }
}
