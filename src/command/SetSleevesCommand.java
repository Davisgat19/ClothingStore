package command;

import business.Clothing;
import business.TShirt;

public class SetSleevesCommand implements Command {
    private String sleeves;

    public SetSleevesCommand(String sleeves) {
        this.sleeves = sleeves;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setSleeves(sleeves);
        }
    }
}
