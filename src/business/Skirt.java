package business;


public class Skirt extends Clothing {
    private String pattern;
    private String waistline;

    public Skirt(String id, String name, String size, double price, String material, String color, String pattern, String waistline) {
        super(id, name, size, price, material, color);
        this.pattern = pattern;
        this.waistline = waistline;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Pattern: " + pattern + ", Waistline: " + waistline);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }
}
