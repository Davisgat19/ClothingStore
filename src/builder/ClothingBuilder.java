package builder;

import business.Clothing;

public interface ClothingBuilder {
    ClothingBuilder setSize(String size);
    ClothingBuilder setMaterial(String material);
    ClothingBuilder setColor(String color);
    Clothing build();
}
