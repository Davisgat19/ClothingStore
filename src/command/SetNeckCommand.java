package command;

import business.Clothing;
import business.TShirt;

public class SetNeckCommand implements Command {
    private String neck;

    public SetNeckCommand(String neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setNeck(neck);
        }
    }
}
