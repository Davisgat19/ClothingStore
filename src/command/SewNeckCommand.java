package command;

import business.Clothing;
import business.TShirt;

public class SewNeckCommand implements Command {
    private String neck;

    public SewNeckCommand(String sew) {
        this.neck = neck;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setNeck(neck);
            System.out.println("Neck adjusted to: ");
        }
    }
}
