package builder;

import business.TShirt;

public class TShirtBuilder implements ClothingBuilder {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;

    public TShirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public TShirtBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public TShirtBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public TShirtBuilder setColor(String color) {
        this.color = color;
        return this;
    }


    public TShirtBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TShirtBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TShirt build() {
        return new TShirt(id, name, size, price, material, color);
    }
}
