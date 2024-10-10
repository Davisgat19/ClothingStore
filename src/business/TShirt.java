package business;

public class TShirt extends Clothing {
    private final String sleeve;
    private final String neck;

    public TShirt(String id, String name, String size, double price, String material, String color, String sleeve, String neck) {
        super(id, name, size, price, material, color);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Sleeve: " + sleeve + ", Neck: " + neck +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
