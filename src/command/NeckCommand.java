package command;

import business.Clothing;
import business.TShirt;

public class NeckCommand implements Command {
    private String neck;

    public NeckCommand(String neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setNeck(neck);
            System.out.println("TShirt neck adjusted to: " + neck);
        }
    }
}
