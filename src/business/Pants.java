package business;

public class Pants extends Clothing {
    private final String fit;
    private final String length;

    public Pants(String id, String name, String size, double price, String material, String color, String fit, String length) {
        super(id, name, size, price, material, color);
        this.fit = fit;
        this.length = length;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Fit: " + fit + ", Length: " + length +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
