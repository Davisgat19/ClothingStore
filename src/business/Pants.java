package business;

public class Pants extends Clothing {
    private String fit;
    private String length;

    public Pants(String id, String name, String size, double price, String material, String color, String fit, String length) {
        super(id, name, size, price, material, color);
        this.fit = fit;
        this.length = length;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Fit: " + fit + ", Length: " + length);
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
