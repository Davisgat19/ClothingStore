package command;

import business.Clothing;
import business.Skirt;

public class AddWaistLineCommand implements Command {
    private String waistline;

    public AddWaistLineCommand(String waistline) {
        this.waistline = waistline;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaistline(waistline);
            System.out.println("Waistline adjusted to: ");
        }
    }
}
