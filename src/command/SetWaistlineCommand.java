package command;

import business.Clothing;
import business.Skirt;

public class SetWaistlineCommand implements Command {
    private String waistline;

    public SetWaistlineCommand(String waistline) {
        this.waistline = waistline;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaistline(waistline);
        }
    }
}
