package command;

import business.Clothing;
import business.Skirt;

public class WaistlineCommand implements Command {
    private String waistline;

    public WaistlineCommand(String waistline) {
        this.waistline = waistline;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaistline(waistline);
            System.out.println("Skirt waistline adjusted to: " + waistline);
        }
    }
}
