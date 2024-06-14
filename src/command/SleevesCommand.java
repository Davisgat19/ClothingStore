package command;

import business.Clothing;
import business.TShirt;

public class SleevesCommand implements Command {
    private String sleeves;

    public SleevesCommand(String sleeves) {
        this.sleeves = sleeves;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt) {
            ((TShirt) clothing).setSleeves(sleeves);
            System.out.println("TShirt sleeves adjusted to: " + sleeves);
        }
    }
}
