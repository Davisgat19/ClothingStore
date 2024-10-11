package command;

import business.Clothing;
import business.TShirt;

public class AdjustSleeveCommand implements Command {
    private String sleeve;

    public AdjustSleeveCommand(String sleeve) {
        this.sleeve = sleeve;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setSleeve(sleeve);
            System.out.println("Sleeves adjusted to: ");
        }
    }
}
