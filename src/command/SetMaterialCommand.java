package command;

import business.Clothing;

public class SetMaterialCommand implements Command {
    private String material;

    public SetMaterialCommand(String material) {
        this.material = material;
    }

    @Override
    public void execute(Clothing clothing) {
        clothing.setMaterial(material);
    }
}
