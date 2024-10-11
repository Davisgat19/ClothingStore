package business;

public class Skirt extends Clothing {
    private String waistline;
    private String pattern;

    public Skirt(String id, String name, String size, double price, String material, String color) {
        super(id, name, size, price, material, color);
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Waistline: " + waistline + ", Pattern: " + pattern +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
