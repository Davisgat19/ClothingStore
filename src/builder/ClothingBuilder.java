package builder;

import business.Clothing;

public interface ClothingBuilder {
    ClothingBuilder setPrice(double price);
    ClothingBuilder setSize(String size);
    ClothingBuilder setMaterial(String material);
    ClothingBuilder setColor(String color);
    Clothing build();
}
