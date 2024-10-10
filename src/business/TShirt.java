package business;

public class TShirt extends Clothing {
    private String sleeves;
    private String neck;

    public TShirt(String id, String name, String size, double price, String material, String color, String sleeves, String neck) {
        super(id, name, size, price, material, color);
        this.sleeves = sleeves;
        this.neck = neck;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Sleeves: " + sleeves + ", Neck: " + neck);
    }

    // Getters och Setters
    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}
