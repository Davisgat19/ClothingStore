package builder;

import business.TShirt;

public class TShirtBuilder implements ClothingBuilder {
    private String size;
    private String material;
    private String color;
    private String sleeves;
    private String neck;

    @Override
    public TShirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public TShirtBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    @Override
    public TShirtBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public TShirtBuilder setSleeves(String sleeves) {
        this.sleeves = sleeves;
        return this;
    }

    public TShirtBuilder setNeck(String neck) {
        this.neck = neck;
        return this;
    }

    @Override
    public TShirt build() {
        TShirt tshirt = new TShirt("TShirt");
        tshirt.setSize(size);
        tshirt.setMaterial(material);
        tshirt.setColor(color);
        tshirt.setSleeves(sleeves);
        tshirt.setNeck(neck);
        return tshirt;
    }
}
