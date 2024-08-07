package builder;

import business.Pants;

public class PantsBuilder implements ClothingBuilder {
    private String size;
    private String material;
    private String color;
    private String fit;
    private String length;

    @Override
    public PantsBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public PantsBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    @Override
    public PantsBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PantsBuilder setFit(String fit) {
        this.fit = fit;
        return this;
    }

    public PantsBuilder setLength(String length) {
        this.length = length;
        return this;
    }

    @Override
    public Pants build() {
        Pants pants = new Pants("Pants");
        pants.setSize(size);
        pants.setMaterial(material);
        pants.setColor(color);
        pants.setFit(fit);
        pants.setLength(length);
        return pants;
    }
}