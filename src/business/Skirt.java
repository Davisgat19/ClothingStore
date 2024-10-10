package business;

public class Skirt extends Clothing {
    private final String waistline;
    private final String pattern;

    public Skirt(String id, String name, String size, double price, String material, String color, String waistline, String pattern) {
        super(id, name, size, price, material, color);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Waistline: " + waistline + ", Pattern: " + pattern +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
