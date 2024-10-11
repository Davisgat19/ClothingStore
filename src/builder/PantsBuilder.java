package builder;

import business.Pants;

public class PantsBuilder implements ClothingBuilder {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;


    public PantsBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PantsBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public PantsBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public PantsBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PantsBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PantsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Pants build() {
        return new Pants(id, name, size, price, material, color);
    }
}
