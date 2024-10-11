package business;

public class Pants extends Clothing {
    private String fit;
    private String length;

    public Pants(String id, String name, String size, double price, String material, String color) {
        super(id, name, size, price, material, color);
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Fit: " + fit + ", Length: " + length +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
