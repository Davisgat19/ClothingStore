package builder;
import business.Skirt;

public class SkirtBuilder implements ClothingBuilder {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;
    private String waistline;
    private String pattern;

    public SkirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public SkirtBuilder setPrice(double price) {
        this.price = price;
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

    public SkirtBuilder setId(String id) {
        this.id = id;
        return this;
    }


    public SkirtBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Skirt build() {
        return new Skirt(id, name, size, price, material, color, waistline, pattern);
    }
}
