package command;

import business.Clothing;
import business.Pants;
import business.Skirt;
import business.TShirt;

public class ClothingCommands {

        public void adjustFit(Clothing clothing) {
                if (clothing instanceof Pants) {
                        System.out.println("Adjusting the fit of the pants...");
                }
        }

        public void adjustLength(Clothing clothing) {
                if (clothing instanceof Pants) {
                        System.out.println("Adjusting the length of the pants...");
                }
        }

        public void addPattern(Clothing clothing) {
                if (clothing instanceof Skirt) {
                        System.out.println("Adding pattern to the skirt...");
                }
        }

        public void addWaistLine(Clothing clothing) {
                if (clothing instanceof Skirt) {
                        System.out.println("Adding waistline to the skirt...");
                }
        }

        public void adjustSleeves(Clothing clothing) {
                if (clothing instanceof TShirt) {
                        System.out.println("Adjusting sleeves of the T-Shirt...");
                }
        }

        public void sewNeck(Clothing clothing) {
                if (clothing instanceof TShirt) {
                        System.out.println("Sewing neck of the T-Shirt...");
                }
        }

}
