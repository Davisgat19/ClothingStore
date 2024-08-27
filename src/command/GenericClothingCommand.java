package command;

import business.Clothing;

public class GenericClothingCommand implements ClothingCommand {
    private final String action;
    private final String attribute;
    private final String value;

    public GenericClothingCommand(String action, String attribute, String value) {
        this.action = action;
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public void execute(Clothing clothing) {
        switch (action.toLowerCase()) {
            case "sew":
                System.out.println("Sewing " + attribute + " on " + clothing.getName() + " to " + value);
                applyAction(clothing, attribute, value);
                break;
            case "cut":
                System.out.println("Cut " + attribute + " on " + clothing.getName() + " to " + value);
                applyAction(clothing, attribute, value);
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }

    private void applyAction(Clothing clothing, String attribute, String value) {
        switch (attribute.toLowerCase()) {
            case "fit":
                if (clothing instanceof business.Pants) {
                    ((business.Pants) clothing).setFit(value);
                }
                break;
            case "length":
                if (clothing instanceof business.Pants) {
                    ((business.Pants) clothing).setLength(value);
                }
                break;
            case "neck":
                if (clothing instanceof business.TShirt) {
                    ((business.TShirt) clothing).setNeck(value);
                }
                break;
            case "sleeves":
                if (clothing instanceof business.TShirt) {
                    ((business.TShirt) clothing).setSleeves(value);
                }
                break;
            case "waistline":
                if (clothing instanceof business.Skirt) {
                    ((business.Skirt) clothing).setWaistline(value);
                }
                break;
            case "pattern":
                if (clothing instanceof business.Skirt) {
                    ((business.Skirt) clothing).setPattern(value);
                }
                break;
            default:
                System.out.println("Invalid attribute: " + attribute);
        }
    }
}
