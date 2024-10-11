package business;

public class TShirt extends Clothing {
    private String sleeve;
    private String neck;

    public TShirt(String id, String name, String size, double price, String material, String color) {
        super(id, name, size, price, material, color);
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getName() + ", Size: " + getSize() + ", Material: " + getMaterial() +
                ", Color: " + getColor() + ", Sleeve: " + sleeve + ", Neck: " + neck +
                ", Price: $" + String.format("%.2f", getPrice()));
    }
}
