package builder;

import business.Skirt;

public class SkirtBuilder implements ClothingBuilder{
    private String size;
    private String material;
    private String color;
    private String waistline;
    private String pattern;

    public SkirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }


    public SkirtBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public SkirtBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public SkirtBuilder setWaistline(String waistline) {
        this.waistline = waistline;
        return this;
    }

    public SkirtBuilder setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public Skirt build() {
        Skirt skirt = new Skirt("Skirt");
        skirt.setSize(size);
        skirt.setMaterial(material);
        skirt.setColor(color);
        skirt.setWaistline(waistline);
        skirt.setPattern(pattern);
        return skirt;
    }
}
